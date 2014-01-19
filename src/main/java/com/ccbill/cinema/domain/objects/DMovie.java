package com.ccbill.cinema.domain.objects;

import java.io.Serializable;

public class DMovie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public int movieId;
	public String movieName;
	private DGenre movieGenre;
	private DCountry country;
	private float moviePrice;
	
	public DMovie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DMovie(int movieId, String movieName, DGenre movieGenre, DCountry country, float moviePrice) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.country = country;
		this.moviePrice = moviePrice;
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
	public DGenre getMovieGenre() {
		return movieGenre;
	}
	
	/**
	 * @param movieGenre the movieGenre to set
	 */
	public void setMovieGenre(DGenre movieGenre) {
		this.movieGenre = movieGenre;
	}
	
	/**
	 * @return the countryId
	 */
	public DCountry getCountryId() {
		return country;
	}
	
	/**
	 * @param countryId the countryId to set
	 */
	public void setCountry(DCountry country) {
		this.country = country;
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
