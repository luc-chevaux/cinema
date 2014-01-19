package com.ccbill.cinema.domain.objects;

import java.io.Serializable;

public class DCountry implements Serializable {
	private static final long serialVersionUID = 1L;
	private int countryId;
	private String countryName;
	private String countryAcronym;
	
	public DCountry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DCountry(int countryId, String countryName, String countryAcronym) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryAcronym = countryAcronym;
	}

	/**
	 * @return the countryId
	 */
	public int getCountryId() {
		return countryId;
	}
	
	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}
	
	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	/**
	 * @return the countryAcronym
	 */
	public String getCountryAcronym() {
		return countryAcronym;
	}
	
	/**
	 * @param countryAcronym the countryAcronym to set
	 */
	public void setCountryAcronym(String countryAcronym) {
		this.countryAcronym = countryAcronym;
	}
}
