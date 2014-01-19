package com.ccbill.cinema.domain.dbmodels;

import java.io.Serializable;
import java.util.Date;

public class Purchase implements Serializable {
	private static final long serialVersionUID = 1L;
	private int purchaseId;
	private Date purchaseDate;
	private int customerId;
	private int scheduleId;
	private String purchaseSitCode;
	private String purchaseCCNumber;
	private float purchasePrice;
	
	/**
	 * @return the purchaseId
	 */
	public int getPurchaseId() {
		return purchaseId;
	}
	
	/**
	 * @param purchaseId the purchaseId to set
	 */
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	
	/**
	 * @return the purchaseDate
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	/**
	 * @param purchaseDate the purchaseDate to set
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
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
	 * @return the scheduleId
	 */
	public int getScheduleId() {
		return scheduleId;
	}
	
	/**
	 * @param scheduleId the scheduleId to set
	 */
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	/**
	 * @return the purchaseSitCode
	 */
	public String getPurchaseSitCode() {
		return purchaseSitCode;
	}
	
	/**
	 * @param purchaseSitCode the purchaseSitCode to set
	 */
	public void setPurchaseSitCode(String purchaseSitCode) {
		this.purchaseSitCode = purchaseSitCode;
	}
	
	/**
	 * @return the purchaseCCNumber
	 */
	public String getPurchaseCCNumber() {
		return purchaseCCNumber;
	}
	
	/**
	 * @param purchaseCCNumber the purchaseCCNumber to set
	 */
	public void setPurchaseCCNumber(String purchaseCCNumber) {
		this.purchaseCCNumber = purchaseCCNumber;
	}
	
	/**
	 * @return the purchasePrice
	 */
	public float getPurchasePrice() {
		return purchasePrice;
	}
	
	/**
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
