package com.ccbill.cinema.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ccbill.cinema.domain.dbmodels.Customer;
@Repository
public class CustomerRepository extends AbstractRepository {
	/**
	 * @param name
	 * @return
	 */
	public Customer findCustomerByName(String name) {
		Customer customer = (Customer) super.jdbcTemplate.queryForObject(
				super.getQueryById("FIND_CUSTOMER_BY_NAME"),
			    new Object[]{name},
			    new RowMapper<Object>() {
			        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Customer cu = new Customer();
			        	cu.setCustomerEmail(rs.getString("customerEmail"));
			        	cu.setCustomerId(rs.getInt("customerId"));
			        	cu.setCustomerUsername(rs.getString("customerUsername"));
			            return cu;
			        }
			    });
		return customer;
	}

	/**
	 * @param customerUsername
	 * @param customerEmail
	 * @param customerPassword
	 * @return
	 * @throws Exception
	 */
	public boolean registerCustomer (String customerUsername, String customerEmail, String customerPassword) throws Exception {
		Object[] params = new Object[] {customerUsername,
										customerEmail,
										customerPassword};
		
		int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		
		int row = super.jdbcTemplate.update(super.getQueryById("INSERT_CUSTOMER"), params, types);
		
		return (row==0) ? false : true;
	}
}
