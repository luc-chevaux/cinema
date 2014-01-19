/**
 * This is the shopping cart controller
 */
package com.ccbill.cinema.controllers;

/*
 * Import section
 */
import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ccbill.cinema.domain.dbmodels.CreditCardFormModel;
import com.ccbill.cinema.domain.objects.DSchedule;
import com.ccbill.cinema.services.PurchaseService;
import com.ccbill.cinema.services.ScheduleService;

/**
 * This class describes the Shopping Cart controller and contains its actions
 * @author luca martini
 * @category controllers
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping("/shoppingCart/*")
public class ShoppingCartController {
	
	@Autowired
	PurchaseService purchaseSvc;
	
	@Autowired
	ScheduleService scheduleSvc;
	
	private static final Logger log = Logger.getLogger(ShoppingCartController.class);
	
	/**
     * Shopping cart homepage handler
     * @name index
     * @since 1.0.0
     * @author luca martini
     * @version 1.0.0 
     */
	@RequestMapping(value={"/shoppingCart/cart.html"}, method=RequestMethod.GET)
	public String index(ModelMap model, Principal principal) {
		return "shoppingCart/cart";
	}
	
	/**
     * Shopping cart homepage handler
     * @name index
     * @since 1.0.0
     * @author luca martini
     * @version 1.0.0 
     */
	@RequestMapping(value={"/shoppingCart/buy.html"}, method=RequestMethod.GET)
	public String buy(ModelMap model, Principal principal, @RequestParam int idSchedule) {
		DSchedule schedule = scheduleSvc.getScheduleById(idSchedule);
		CreditCardFormModel ccmodel = new CreditCardFormModel();
		ccmodel.setIdSchedule(idSchedule);
		
		model.addAttribute("schedule", schedule);
		model.addAttribute("creditCardModel", ccmodel);
		
		return "shoppingCart/buy";
	}
	
	@RequestMapping(value={"/shoppingCart/buyScheduledEvent"}, method=RequestMethod.POST)
	public String processForm(@ModelAttribute(value="creditCardModel") CreditCardFormModel model, Principal principal, RedirectAttributes redirectAttrs) {
		// do some controls on your credit card
		boolean valid = true;
		// buy
		if (valid == true) { purchaseSvc.buySchedule(model.getIdSchedule(), principal.getName(), model.getCreditNumber()); }
		//view.addAttribute("thanks", "Thanks for booking in our cinema!");
		return "redirect:/shoppingCart/cart.html";
	}
}
