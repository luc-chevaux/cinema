/**
 * This is the Schedule Service
 */
package com.ccbill.cinema.services;

import org.springframework.stereotype.Service;

import com.ccbill.cinema.domain.mapper.Page;
import com.ccbill.cinema.domain.objects.DSchedule;

/**
 * This interface describes the Schedule Service
 * @author luca martini
 * @category services
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface ScheduleService {
	/**
	 * 
	 */
	public Page<DSchedule> getAllSchedules(int pageNo);
	
	/**
	 * 
	 */
	public void getSchedulesByMovie();
	
	/**
	 * 
	 */
	public void getSchedulesByTheatre();
	
	/**
	 * 
	 */
	public void getSchedulesBySlot();

	/**
	 * 
	 * @param idSchedule
	 */
	public DSchedule getScheduleById(int idSchedule);
}
