/**
 * This is the Purchase Service
 */
package com.ccbill.cinema.services;

import org.springframework.stereotype.Service;

import com.ccbill.cinema.domain.mapper.Page;
import com.ccbill.cinema.domain.objects.DPurchase;

/**
 * This interface describes the Purchase Service
 * @author luca martini
 * @category services
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface PurchaseService {
	/**
	 * 
	 */
	public boolean buySchedule(int idSchedule, String username, String ccNumber);
	
	/**
	 * 
	 */
	public void buySchedules();
	
	/**
	 * 
	 */
	public Page<DPurchase> getPurchasedSchedulesByUser(String principalName, int pageNo, int pageSize);
	
	/**
	 * 
	 */
	public void modifyPurchasedSchedule();
}
