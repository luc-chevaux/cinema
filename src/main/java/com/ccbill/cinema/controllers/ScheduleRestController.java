/**
 * This is the schedule rest controller
 */
package com.ccbill.cinema.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccbill.cinema.component.MessageProvider;
import com.ccbill.cinema.domain.mapper.Page;
import com.ccbill.cinema.domain.objects.DSchedule;
import com.ccbill.cinema.services.ScheduleService;

/**
 * This class describes the schedule controller and contains its actions
 * @author luca martini
 * @category controllers
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = { "/rest/schedule" }, method = RequestMethod.GET)
public class ScheduleRestController {
	@Autowired
	private ScheduleService scheduleSvc;

	private static final Logger log = Logger.getLogger(ScheduleRestController.class);
	
	/**
	 * default constructor
	 */
	public ScheduleRestController() {
		log.info(MessageProvider.getMessage("start.controller.rest.schedule"));
	}
	
	/**
	 * 
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value = "/pages/{pageNo}", method = RequestMethod.GET)
	public @ResponseBody Page<DSchedule> schedule(@PathVariable int pageNo) {
		log.info(MessageProvider.getMessage("start.action.controller.schedule.call.service"));
		Page<DSchedule> schedules = scheduleSvc.getAllSchedules(pageNo);
		return schedules;
	}
}