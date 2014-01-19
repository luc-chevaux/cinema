/**
 * This is the schedule controller
 */
package com.ccbill.cinema.controllers;

/**
 * Import Section
 */
import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccbill.cinema.services.impl.ScheduleServiceImpl;

/**
 * This class describes the Schedule controller and contains its actions
 * @author luca martini
 * @category controllers
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping("/upcomingSchedules/*")
public class ScheduleController {
	@Autowired
	ScheduleServiceImpl scheduleSvc;
	
	private static final Logger log = Logger.getLogger(ScheduleController.class);
	
	/**
     * Schedule search handler
     * @name search
     * @since 1.0.0
     * @author luca martini
     * @version 1.0.0 
     */
	@RequestMapping(value={"/upcomingSchedules/search.html"}, method=RequestMethod.GET)
	public String search(ModelMap model, Principal principal) {
		return "upcomingSchedules/search";
	}
	
	/**
     * Schedule refund handler
     * @name refund
     * @since 1.0.0
     * @author luca martini
     * @version 1.0.0 
     */
	@RequestMapping(value={"/upcomingSchedules/refund.html"}, method=RequestMethod.GET)
	public String refund(ModelMap model, Principal principal) {
		return "upcomingSchedules/refund";
	}
}
