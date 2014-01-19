package com.ccbill.cinema.domain.dbmodels;

import java.io.Serializable;

public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	public enum Genre {
		HORROR("HORROR"), THRILLER("THRILLER"), DRAMA("DRAMA"), 
		SPAGHETTI_WESTERN("SPAGHETTI WESTERN"), COMEDY("COMEDY"), 
		ROMANTIC("ROMANTIC");
		
		String name;
		
		Genre(String name) {
			this.name = name;
		}
		public String toString() {
			return name;
		}
	}
	
	public int movieId;
	public String movieName;
	private Genre movieGenre;
	private int countryId;
	private float moviePrice;
	
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
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}
	
	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	/**
	 * @return the movieGenre
	 */
	public Genre getMovieGenre() {
		return movieGenre;
	}
	
	/**
	 * @param movieGenre the movieGenre to set
	 */
	public void setMovieGenre(Genre movieGenre) {
		this.movieGenre = movieGenre;
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
	 * @return the moviePrice
	 */
	public float getMoviePrice() {
		return moviePrice;
	}
	
	/**
	 * @param moviePrice the moviePrice to set
	 */
	public void setMoviePrice(float moviePrice) {
		this.moviePrice = moviePrice;
	}
}
