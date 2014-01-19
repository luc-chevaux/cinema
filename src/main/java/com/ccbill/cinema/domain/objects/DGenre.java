package com.ccbill.cinema.domain.objects;

public enum DGenre {
	HORROR("HORROR"), THRILLER("THRILLER"), DRAMA("DRAMA"), 
	WESTERN("WESTERN"), COMEDY("COMEDY"), 
	ROMANTIC("ROMANTIC");
	
	String name;
	
	DGenre(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}