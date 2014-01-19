package com.ccbill.cinema.services.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccbill.cinema.component.MessageProvider;
import com.ccbill.cinema.configuration.CinemaConfiguration;
import com.ccbill.cinema.domain.mapper.Page;
import com.ccbill.cinema.domain.objects.DSchedule;
import com.ccbill.cinema.repositories.ScheduleRepository;
import com.ccbill.cinema.services.ScheduleService;

/**
 * This class describes the Schedule service layer
 * @author luca martini
 * @category services
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	private static final Logger log = Logger.getLogger(ScheduleServiceImpl.class);
	
	/**
	 * @see ScheduleService#getAllSchedules(int pageNo)
	 */
	@Override
	public Page<DSchedule> getAllSchedules(int pageNo) {
		Page<DSchedule> schedules = new Page<DSchedule>();
		try {
			log.info(MessageProvider.getMessage("start.action.service.schedule.getAllSchedules"));
			schedules = scheduleRepository.findAll(pageNo, CinemaConfiguration.pageSize);
			log.info(MessageProvider.getBindedMessage("db.service.schedule.founded", new Object[] {schedules.getPagesAvailable()}));
		} catch (SQLException e) {
			log.warn("");
			schedules = new Page<DSchedule>();			
		}
		log.error(MessageProvider.getMessage("end.action.service.schedule.getAllSchedules"));
		return schedules;
	}

	/**
	 * @see ScheduleService#getSchedulesByMovie()
	 */
	@Override
	public void getSchedulesByMovie() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see ScheduleService#getSchedulesByTheatre()
	 */
	@Override
	public void getSchedulesByTheatre() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see ScheduleService#getSchedulesBySlot()
	 */
	@Override
	public void getSchedulesBySlot() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see ScheduleService#getSchedulesById
	 */
	@Override
	public DSchedule getScheduleById(int idSchedule) {
		return scheduleRepository.findById(idSchedule);
	}

}
