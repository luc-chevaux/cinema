package com.ccbill.cinema.services.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccbill.cinema.domain.mapper.Page;
import com.ccbill.cinema.domain.objects.DPurchase;
import com.ccbill.cinema.repositories.PurchaseRepository;
import com.ccbill.cinema.services.PurchaseService;

/**
 * This class describes the Schedule service layer
 * @author luca martini
 * @category services
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	private static final Logger log = Logger.getLogger(PurchaseServiceImpl.class);
	
	/**
	 * @see PurchaseService#buySchedule()
	 */
	@Override
	public boolean buySchedule(int idSchedule, String username, String ccNumber) {
		return purchaseRepository.buy(username, idSchedule, ccNumber);
	}

	/**
	 * @see PurchaseService#buySchedules()
	 */
	@Override
	public void buySchedules() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see PurchaseService#getPurchasedSchedulesByUser()
	 */
	@Override
	public Page<DPurchase> getPurchasedSchedulesByUser(String principalName, int pageNo, int pageSize) {
		try {
			return purchaseRepository.getPurchasedSchedulesByUser(principalName, pageNo, pageSize);
		} catch (SQLException e) {
			return new Page<DPurchase>();
		}
	}

	/**
	 * @see PurchaseService#modifyPurchasedSchedule()
	 */
	@Override
	public void modifyPurchasedSchedule() {
		// TODO Auto-generated method stub
		
	}
}
