package com.ccbill.cinema.domain.objects;

import java.io.Serializable;
import java.util.Date;

public class DSchedule implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idSchedule;
	private DTheatre theatre;
	private DSlot slot;
	private DMovie movie;
	private Date scheduleDate;
	
	public DSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DSchedule(int idSchedule, DTheatre theatre, DSlot slot,
			DMovie movie, Date scheduleDate) {
		super();
		this.idSchedule = idSchedule;
		this.theatre = theatre;
		this.slot = slot;
		this.movie = movie;
		this.scheduleDate = scheduleDate;
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
	 * @return the theatre
	 */
	public DTheatre getTheatre() {
		return theatre;
	}
	
	/**
	 * @param theatre the theatre to set
	 */
	public void setTheatre(DTheatre theatre) {
		this.theatre = theatre;
	}
	
	/**
	 * @return the slot
	 */
	public DSlot getSlot() {
		return slot;
	}
	
	/**
	 * @param slot the slot to set
	 */
	public void setSlot(DSlot slot) {
		this.slot = slot;
	}
	
	/**
	 * @return the movie
	 */
	public DMovie getMovie() {
		return movie;
	}
	
	/**
	 * @param movie the movie to set
	 */
	public void setMovie(DMovie movie) {
		this.movie = movie;
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
}
