package com.ccbill.cinema.domain.objects;

import java.io.Serializable;

public class DCustomer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int customerId;
	private String customerUsername;
	private String customerEmail;
	private String customerPassword;
	
	public DCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DCustomer(int customerId, String customerUsername,
			String customerEmail, String customerPassword) {
		super();
		this.customerId = customerId;
		this.customerUsername = customerUsername;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * @return the customerUsername
	 */
	public String getCustomerUsername() {
		return customerUsername;
	}
	
	/**
	 * @param customerUsername the customerUsername to set
	 */
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}
	
	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	/**
	 * @return the customerPassword
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}
	
	/**
	 * @param customerPassword the customerPassword to set
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
}
