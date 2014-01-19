package com.ccbill.cinema.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.ccbill.cinema.domain.dbmodels.Customer;
import com.ccbill.cinema.domain.mapper.Page;
import com.ccbill.cinema.domain.mapper.PaginationHelper;
import com.ccbill.cinema.domain.objects.DCountry;
import com.ccbill.cinema.domain.objects.DCustomer;
import com.ccbill.cinema.domain.objects.DGenre;
import com.ccbill.cinema.domain.objects.DMovie;
import com.ccbill.cinema.domain.objects.DPurchase;
import com.ccbill.cinema.domain.objects.DSchedule;
import com.ccbill.cinema.domain.objects.DSlot;
import com.ccbill.cinema.domain.objects.DTheatre;

/**
 * This class describes the Purchase Repository
 * @author luca martini
 * @category repository
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class PurchaseRepository extends AbstractRepository {
	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	/**
	 * 
	 * @return
	 */
	public Page<DPurchase> getPurchasedSchedulesByUser(String username, final int pageNo, final int pageSize) throws SQLException {
		PaginationHelper<DPurchase> ph = new PaginationHelper<DPurchase>();
		return ph.fetchPage(super.jdbcTemplate,
				super.getQueryById("FIND_ALL_PURCHASE_COUNT"),
				super.getQueryById("FIND_ALL_PURCHASE_BY_USER"),
				new Object[] {username}, pageNo, pageSize,
				new ParameterizedRowMapper<DPurchase>() {
					@Override
					public DPurchase mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						DPurchase purchase = new DPurchase();
						// purchase data
						purchase.setPurchaseDate(rs.getDate("purchaseDate"));
						purchase.setPurchaseId(rs.getInt("purchaseId"));
						purchase.setPurchasePrice(rs.getFloat("purchasePrice"));
						purchase.setPurchaseSitCode(rs
								.getString("purchaseSitCode"));
						// schedule domain object
						purchase.setSchedule(new DSchedule(rs
								.getInt("idSchedule"), new DTheatre(rs
								.getInt("theatreId"), rs
								.getInt("theatreShowsNumber"), rs
								.getInt("theatreRows"), rs
								.getInt("theatreColumns"), rs
								.getString("theatreName")), new DSlot(rs
								.getInt("slotId"), rs
								.getString("slotDescription"), rs
								.getString("slotStartTime"), rs
								.getString("slotEndTime"), rs
								.getInt("slotPaused")), new DMovie(rs
								.getInt("movieId"), rs.getString("movieName"),
								DGenre.valueOf(rs.getString("movieGenre")),
								new DCountry(rs.getInt("countryId"), rs
										.getString("countryName"), rs
										.getString("countryAcronym")), rs
										.getFloat("moviePrice")), rs
								.getDate("scheduleDate")));
						// customer domain object
						purchase.setCustomer(new DCustomer(rs
								.getInt("customerId"), rs
								.getString("customerUsername"), rs
								.getString("customerEmail"), rs
								.getString("customerPassword")));

						return purchase;
					}
				});
	}

	public boolean buy(String username, int idSchedule, String ccNumber) {
		// find schedule by name
		DSchedule schedule = scheduleRepository.findById(idSchedule);
		Customer customer = customerRepository.findCustomerByName(username);
		
		// current datetime
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		
		// define query arguments		
		Object[] params = new Object[] {currentTime,
										customer.getCustomerId(),
										schedule.getIdSchedule(),
										10,
										ccNumber, 
										schedule.getMovie().getMoviePrice()};

		// define SQL types of the arguments
		// purchaseDate, customerId, scheduleId, purchaseSitCode, purchaseCCNumber, purchasePrice
		int[] types = new int[] { Types.DATE, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.FLOAT };

		// execute the query
		int row = super.jdbcTemplate.update(super.getQueryById("INSERT_PURCHASE"), params, types);
		
		return (row==0) ? false : true;
	}
	/**
	 * 
	 * @return
	 */
	public DPurchase findById() {
		return null;
	}

	/**
	 * 
	 * @param customer
	 * @return
	 */
	List<DPurchase> findByCustomer(DCustomer customer) {
		return null;
	}

	/**
	 * 
	 * @param schedule
	 * @return
	 */
	List<DPurchase> findBySchedule(DSchedule schedule) {
		return null;
	}
}
