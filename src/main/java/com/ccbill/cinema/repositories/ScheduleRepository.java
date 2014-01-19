package com.ccbill.cinema.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.ccbill.cinema.domain.dbmodels.Schedule;
import com.ccbill.cinema.domain.mapper.Page;
import com.ccbill.cinema.domain.mapper.PaginationHelper;
import com.ccbill.cinema.domain.objects.DCountry;
import com.ccbill.cinema.domain.objects.DGenre;
import com.ccbill.cinema.domain.objects.DMovie;
import com.ccbill.cinema.domain.objects.DSchedule;
import com.ccbill.cinema.domain.objects.DSlot;
import com.ccbill.cinema.domain.objects.DTheatre;

/**
 * This class describes the Schedule Repository
 * @author luca martini
 * @category repository
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class ScheduleRepository extends AbstractRepository {
	/**
	 * 
	 * @return
	 */
	public Page<DSchedule> findAll(final int pageNo, final int pageSize) throws SQLException {
		PaginationHelper<DSchedule> ph = new PaginationHelper<DSchedule>();
		return ph.fetchPage(super.jdbcTemplate,
				super.getQueryById("FIND_ALL_SCHEDULES_COUNT"),
				super.getQueryById("FIND_ALL_SCHEDULES"), new Object[] {},
				pageNo, pageSize, new ParameterizedRowMapper<DSchedule>() {
					@Override
					public DSchedule mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						DSchedule schedule = new DSchedule();
						// schedule data
						schedule.setIdSchedule(rs.getInt("idSchedule"));
						schedule.setScheduleDate(rs.getDate("scheduleDate"));
						// movie domain object
						schedule.setMovie(new DMovie(rs.getInt("movieId"), rs
								.getString("movieName"), DGenre.valueOf(rs
								.getString("movieGenre")), new DCountry(rs
								.getInt("countryId"), rs
								.getString("countryName"), rs
								.getString("countryAcronym")), rs
								.getFloat("moviePrice")));
						// slot domain object
						schedule.setSlot(new DSlot(rs.getInt("slotId"), rs
								.getString("slotDescription"), rs
								.getString("slotStartTime"), rs
								.getString("slotEndTime"), rs
								.getInt("slotPaused")));
						// theatre domain object
						schedule.setTheatre(new DTheatre(
								rs.getInt("theatreId"), rs
										.getInt("theatreShowsNumber"), rs
										.getInt("theatreRows"), rs
										.getInt("theatreColumns"), rs
										.getString("theatreName")));

						return schedule;
					}
				});
	}

	/**
	 * 
	 * @return
	 */
	public DSchedule findById(int idSchedule) {
		DSchedule schedule = (DSchedule) super.jdbcTemplate.queryForObject(
				super.getQueryById("FIND_SCHEDULE_BY_ID"),
			    new Object[]{idSchedule},
			    new RowMapper<Object>() {
			        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	DSchedule sch = new DSchedule();
			            // mapping
			        	sch.setIdSchedule(rs.getInt("idSchedule"));
			        	sch.setMovie(new DMovie(rs.getInt("movieId"), 
				    							rs.getString("movieName"), 
				    							DGenre.valueOf(rs.getString("movieGenre")), 
				    							new DCountry(rs.getInt("countryId"), 
				    										rs.getString("countryName"), 
				    										rs.getString("countryAcronym")), 
				    							rs.getFloat("moviePrice")));
			        	sch.setScheduleDate(rs.getDate("scheduleDate"));
			        	sch.setSlot(new DSlot(rs.getInt("slotId"), 
			        							rs.getString("slotDescription"), 
			        							rs.getString("slotStartTime"), 
			        							rs.getString("slotEndTime"), 
			        							rs.getInt("slotPaused")));
			        	sch.setTheatre(new DTheatre(rs.getInt("theatreId"), 
			        								rs.getInt("theatreShowsNumber"), 
			        								rs.getInt("theatreRows"), 
			        								rs.getInt("theatreColumns"), 
			        								rs.getString("theatreName")));
			            return sch;
			        }
			    });
		return schedule;
	}

	/**
	 * 
	 * @param theatre
	 * @return
	 */
	List<Schedule> findByTheatre(DTheatre theatre) {
		return null;
	}

	/**
	 * 
	 * @param slot
	 * @return
	 */
	List<Schedule> findBySlot(DSlot slot) {
		return null;
	}

	/**
	 * 
	 * @param movie
	 * @return
	 */
	List<Schedule> findByMovie(DMovie movie) {
		return null;
	}
}
