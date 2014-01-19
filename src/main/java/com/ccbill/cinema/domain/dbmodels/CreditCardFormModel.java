package com.ccbill.cinema.domain.dbmodels;

import java.io.Serializable;

public class CreditCardFormModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String creditNumber;
	private String creditSecurity;
	private int idSchedule;
	
	/**
	 * @return the creditNumber
	 */
	public String getCreditNumber() {
		return creditNumber;
	}
	/**
	 * @param creditNumber the creditNumber to set
	 */
	public void setCreditNumber(String creditNumber) {
		this.creditNumber = creditNumber;
	}
	/**
	 * @return the idSchedule
	 */
	public int getIdSchedule() {
		return idSchedule;
	}
	/**
	 * @param idSchedule the idSchedule to set
	 */
	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}
	/**
	 * @return the creditSecurity
	 */
	public String getCreditSecurity() {
		return creditSecurity;
	}
	/**
	 * @param creditSecurity the creditSecurity to set
	 */
	public void setCreditSecurity(String creditSecurity) {
		this.creditSecurity = creditSecurity;
	}
}
