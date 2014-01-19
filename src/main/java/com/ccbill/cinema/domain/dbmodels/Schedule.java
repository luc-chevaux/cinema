package com.ccbill.cinema.domain.dbmodels;

import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idSchedule;
	private int theatreId;
	private int slotId;
	private int movieId;
	private Date scheduleDate;
	
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
	 * @return the slotId
	 */
	public int getSlotId() {
		return slotId;
	}
	
	/**
	 * @param slotId the slotId to set
	 */
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	
	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}
	
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	/**
	 * @return the scheduleDate
	 */
	public Date getScheduleDate() {
		return scheduleDate;
	}
	
	/**
	 * @param scheduleDate the scheduleDate to set
	 */
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
