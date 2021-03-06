package com.ccbill.cinema.domain.objects;

import java.io.Serializable;

public class DSlot implements Serializable {
	private static final long serialVersionUID = 1L;
	private int slotId;
	private String slotDescription;	
	private String slotStartTime;
	private String slotEndTime;
	private int slotPaused;
	
	public DSlot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DSlot(int slotId, String slotDescription, String slotStartTime, String slotEndTime, int slotPaused) {
		super();
		this.slotId = slotId;
		this.slotDescription = slotDescription;
		this.slotStartTime = slotStartTime;
		this.slotEndTime = slotEndTime;
		this.slotPaused = slotPaused;
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
	 * @return the slotDescription
	 */
	public String getSlotDescription() {
		return slotDescription;
	}
	
	/**
	 * @param slotDescription the slotDescription to set
	 */
	public void setSlotDescription(String slotDescription) {
		this.slotDescription = slotDescription;
	}
	
	/**
	 * @return the slotStartTime
	 */
	public String getSlotStartTime() {
		return slotStartTime;
	}
	
	/**
	 * @param slotStartTime the slotStartTime to set
	 */
	public void setSlotStartTime(String slotStartTime) {
		this.slotStartTime = slotStartTime;
	}
	
	/**
	 * @return the slotEndTime
	 */
	public String getSlotEndTime() {
		return slotEndTime;
	}
	
	/**
	 * @param slotEndTime the slotEndTime to set
	 */
	public void setSlotEndTime(String slotEndTime) {
		this.slotEndTime = slotEndTime;
	}
	
	/**
	 * @return the slotPaused
	 */
	public int getSlotPaused() {
		return slotPaused;
	}
	
	/**
	 * @param slotPaused the slotPaused to set
	 */
	public void setSlotPaused(int slotPaused) {
		this.slotPaused = slotPaused;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
