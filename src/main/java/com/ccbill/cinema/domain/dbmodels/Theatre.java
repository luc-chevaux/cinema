package com.ccbill.cinema.domain.dbmodels;

import java.io.Serializable;

public class Theatre implements Serializable {
	private static final long serialVersionUID = 1L;
	private int theatreId;
	private int theatreShowsNumber;	
	private int theatreRows;
	private int theatreColumns;
	private String theatreName;
	
	/**
	 * @return the theatreId
	 */
	public int getTheatreId() {
		return theatreId;
	}
	
	/**
	 * @param theatreId the theatreId to set
	 */
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	
	/**
	 * @return the theatreShowsNumber
	 */
	public int getTheatreShowsNumber() {
		return theatreShowsNumber;
	}
	
	/**
	 * @param theatreShowsNumber the theatreShowsNumber to set
	 */
	public void setTheatreShowsNumber(int theatreShowsNumber) {
		this.theatreShowsNumber = theatreShowsNumber;
	}
	
	/**
	 * @return the theatreRows
	 */
	public int getTheatreRows() {
		return theatreRows;
	}
	
	/**
	 * @param theatreRows the theatreRows to set
	 */
	public void setTheatreRows(int theatreRows) {
		this.theatreRows = theatreRows;
	}
	
	/**
	 * @return the theatreColumns
	 */
	public int getTheatreColumns() {
		return theatreColumns;
	}
	
	/**
	 * @param theatreColumns the theatreColumns to set
	 */
	public void setTheatreColumns(int theatreColumns) {
		this.theatreColumns = theatreColumns;
	}
	
	/**
	 * @return the theatreName
	 */
	public String getTheatreName() {
		return theatreName;
	}
	
	/**
	 * @param theatreName the theatreName to set
	 */
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
