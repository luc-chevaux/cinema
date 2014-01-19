/**
 * This is the homepage controller
 */
package com.ccbill.cinema.controllers;

/**
 * Import section
 */
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccbill.cinema.component.MessageProvider;
import com.ccbill.cinema.domain.dbmodels.RegistrationCustomer;
import com.ccbill.cinema.services.CustomerService;
import com.ccbill.cinema.services.ScheduleService;

/**
 * This class describes the Index controller (homepage) and contains its actions
 * @author luca martini
 * @category controllers
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping(value={ "/",
						"/index.html",
						"/processRegistration*",
						"/login-error.html", 
						"/welcome.html", 
						"/register.html", 
						"/error.html", 
						"/logout*"})
public class IndexController {	
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private CustomerService customerService;
	
	private static final Logger log = Logger.getLogger(IndexController.class);

	/**
     * Homepage handler
     * @name index
     * @since 1.0.0
     * @author luca martini
     * @version 1.0.0 
     */
	@RequestMapping(value={"/index.html", "/"}, method=RequestMethod.GET)
	public String index(ModelMap model, Principal principal) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String name = principal.getName();
			model.addAttribute("username", name);
			model.addAttribute("message", "Hi " + name + ", welcome to the CCBill cinema!");
			
			log.info(MessageProvider.getMessage("action.controller.index.user.authenticated"));
			return "welcome";
		}
		log.info(MessageProvider.getMessage("action.controller.index.user.notauthenticated"));
		return "index";
	}
	
	/**
     * Handle wrong login request
     * @name loginError
     * @since 1.0.0
     * @author luca martini
     * @version 1.0.0 
     */
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        log.error(MessageProvider.getMessage("action.controller.index.login.failed"));
        return "index";
    }
	
    /**
     * Handle the welcome page
     * @name welcome
     * @since 1.0.0
     * @author luca martini
     * @version 1.0.0 
     */
	@RequestMapping(value={"/welcome.html"}, method=RequestMethod.GET)
	public String welcome(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Hi " + name + ", welcome to the CCBill cinema!");
		log.info(MessageProvider.getBindedMessage("action.controller.index.login.succeed", new Object[]{name}));
		return "welcome";
	}
	
	/**
     * Handle the register page
     * @name register
     * @since 1.0.0
     * @author acaro
     * @version 1.0.0 
     */
	@RequestMapping(value={"/register.html"}, method=RequestMethod.GET)
	public String register(ModelMap model, Principal principal) {
		// crea un registration customer vuoto da associare al form della view
		RegistrationCustomer registrationCustomer = new RegistrationCustomer();
		// aggiunge l'oggetto vuoto al modello gestito dalla view (ModelMap model)
		model.addAttribute(registrationCustomer);
		// lancia la view
		return "register";
	}
	
	@RequestMapping(value={"/processRegistration"}, method=RequestMethod.POST)
	public String processRegistration (ModelMap model, @ModelAttribute(value="registrationCustomer") RegistrationCustomer registrationCustomer) {		
		// questo è il punto dove inserire il controllo di validità della password
		// in modo da poter influenzare direttamente sulla view
		if (registrationCustomer.getCustomerPassword().equals(registrationCustomer.getCustomerConfirmPassword())) {
			// chiama il servizio
			customerService.register(registrationCustomer.getCustomerUsername(), 
							registrationCustomer.getCustomerEmail(), 
							registrationCustomer.getCustomerPassword());
			// ritorna alla pagina di login
			return "redirect:/index.html";
		} else {
			// logga l'errore nella console
			log.error(MessageProvider.getMessage("action.controller.index.login.passwords-not-match"));
			// riaggiunge il modello di input al ModelMap in modo da lasciare il form riempito
			model.addAttribute(registrationCustomer);
			// aggiunge un messaggio di errore per l'utente
			model.addAttribute("message", "Passwords do not match, please try again");
			// ritorna alla pagina di registrazione
			return "register";
		}
	}
	
	/**
     * Handle the errors (web.xml mapped request)
     * @name error
     * @since 1.0.0
     * @author luca martini
     * @version 1.0.0 
     */
    @RequestMapping("/error.html")
    public String error(HttpServletRequest request, Model model) {
        model.addAttribute("errorCode", request.getAttribute("javax.servlet.error.status_code"));
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String errorMessage = null;
        if (throwable != null) {
            errorMessage = throwable.getMessage();
        }
        model.addAttribute("errorMessage", errorMessage.toString());
        log.error(MessageProvider.getMessage(MessageProvider.getMessage("action.controller.error")));
        return "error";
    }
    
    /**
     * Handle the logout request
     * @name logOut
     * @since 1.0.0
     * @author luca martini
     * @version 1.0.0 
     */
    @RequestMapping(value={"/j_spring_security_logout", "/logout"})
    public String logOut(Model model) {
    	SecurityContextHolder.clearContext();
		model.addAttribute("loggedOut", true);
		log.info(MessageProvider.getMessage("action.controller.index.logout"));
		return "index";
    }
}
