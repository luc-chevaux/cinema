package com.ccbill.cinema.domain.objects;

import java.io.Serializable;
import java.util.Date;

public class DPurchase implements Serializable {
	private static final long serialVersionUID = 1L;
	private int purchaseId;
	private Date purchaseDate;
	private DCustomer customer;
	private DSchedule schedule;
	private String purchaseSitCode;
	private String purchaseCCNumber;
	private float purchasePrice;
	
	public DPurchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DPurchase(int purchaseId, Date purchaseDate, DCustomer customer,
			DSchedule schedule, String purchaseSitCode,
			String purchaseCCNumber, float purchasePrice) {
		super();
		this.purchaseId = purchaseId;
		this.purchaseDate = purchaseDate;
		this.customer = customer;
		this.schedule = schedule;
		this.purchaseSitCode = purchaseSitCode;
		this.purchaseCCNumber = purchaseCCNumber;
		this.purchasePrice = purchasePrice;
	}

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
	public DCustomer getCustomer() {
		return customer;
	}
	
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomer(DCustomer customer) {
		this.customer = customer;
	}
	
	/**
	 * @return the scheduleId
	 */
	public DSchedule getSchedule() {
		return schedule;
	}
	
	/**
	 * @param scheduleId the scheduleId to set
	 */
	public void setSchedule(DSchedule schedule) {
		this.schedule = schedule;
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
