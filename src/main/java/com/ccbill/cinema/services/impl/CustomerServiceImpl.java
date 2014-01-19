package com.ccbill.cinema.services.impl;

import java.security.MessageDigest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccbill.cinema.repositories.CustomerRepository;
import com.ccbill.cinema.services.CustomerService;

@Service(value="CustomerService")
public class CustomerServiceImpl implements CustomerService {
	private static final Logger log = Logger.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerRepository customerRepository;
	/**
	 * @see CustomerService#loginCustomer()
	 */
	@Override
	public void loginCustomer() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see CustomerService#logoutCustomer()
	 */
	@Override
	public void logoutCustomer() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see CustomerService#getUserObject()
	 */
	@Override
	public void getUserObject() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @see CustomerService#register(String, String, String)
	 */
	@Override
	public boolean register(String customerUsername, String customerEmail, String customerPassword) {
		try {
			// generate salted password
			MessageDigest passwcust = MessageDigest.getInstance("MD5");
			customerPassword += "{CCBill}";
			passwcust.update(customerPassword.getBytes());
			byte bytepasswd[] = passwcust.digest();
			
			StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < bytepasswd.length; i++) {
	        	sb.append(Integer.toString((bytepasswd[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        
			return customerRepository.registerCustomer(customerUsername, customerEmail, sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
