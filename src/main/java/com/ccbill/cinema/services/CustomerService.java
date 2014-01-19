/**
 * This is the Auth Service
 */
package com.ccbill.cinema.services;

import org.springframework.stereotype.Service;

/**
 * This interface describes the Auth Service
 * 
 * @author luca martini
 * @category services
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface CustomerService {
	/**
	 * 
	 */
	public void loginCustomer();

	/**
	 * 
	 */
	public void logoutCustomer();

	/**
	 * 
	 */
	public void getUserObject();

	/**
	 * 
	 */
	public boolean register(String customerUsername, String customerEmail, String customerPassword);

}
