package com.ccbill.cinema.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ccbill.cinema.domain.objects.DCountry;
import com.ccbill.cinema.domain.objects.DMovie;

/**
 * This class describes the Movie Repository
 * @author luca martini
 * @category repository
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class MovieRepository extends AbstractRepository {
	/**
	 * 
	 * @return
	 */
	public List<DMovie> findAll() {
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public DMovie findById() {
		return null;
	}
	
	/**
	 * 
	 * @param country
	 * @return
	 */
	public List<DMovie> findByCountry(DCountry country) {
		return null;
	}
}