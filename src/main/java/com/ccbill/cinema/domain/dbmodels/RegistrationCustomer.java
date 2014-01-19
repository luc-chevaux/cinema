package com.ccbill.cinema.domain.dbmodels;

import java.io.Serializable;

public class RegistrationCustomer extends Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String customerConfirmPassword;

	/**
	 * @return the customerConfirmPassword
	 */
	public String getCustomerConfirmPassword() {
		return customerConfirmPassword;
	}

	/**
	 * @param customerConfirmPassword the customerConfirmPassword to set
	 */
	public void setCustomerConfirmPassword(String customerConfirmPassword) {
		this.customerConfirmPassword = customerConfirmPassword;
	}
}
