/**
 * This is the purchase rest controller
 */
package com.ccbill.cinema.controllers;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccbill.cinema.component.MessageProvider;
import com.ccbill.cinema.configuration.CinemaConfiguration;
import com.ccbill.cinema.domain.mapper.Page;
import com.ccbill.cinema.domain.objects.DPurchase;
import com.ccbill.cinema.services.PurchaseService;

/**
 * This class describes the purchase controller and contains its actions
 * @author luca martini
 * @category controllers
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = { "/rest/purchase" }, method = RequestMethod.GET)
public class PurchaseRestController {
	@Autowired
	private PurchaseService purchaseSvc;
	
	private static final Logger log = Logger.getLogger(PurchaseRestController.class);
	
	/**
	 * default constructor
	 */
	public PurchaseRestController() {
		log.info(MessageProvider.getMessage("start.controller.rest.purchase"));
	}

	/**
	 * 
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value = "/pages/{pageNo}", method = RequestMethod.GET)
	public @ResponseBody Page<DPurchase> purchase(@PathVariable int pageNo, Principal principal) {
		log.info(MessageProvider.getMessage("start.action.controller.purchase.call.service"));
		Page<DPurchase> purchases = purchaseSvc.getPurchasedSchedulesByUser(principal.getName(), pageNo, CinemaConfiguration.pageSize);
		return purchases;
	}
}
