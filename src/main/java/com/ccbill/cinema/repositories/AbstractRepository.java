package com.ccbill.cinema.repositories;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * This class describes the Abstract Repository
 * @author luca martini
 * @category repository
 * @version 1.0.0
 * @since 1.0.0
 */
public class AbstractRepository {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	@Autowired
    private ApplicationContext context;

	/**
	 * 
	 * @param beanId
	 * @return
	 */
	private Object getBeanFromFactory(String beanId) {
		Object obj = context.getBean(beanId);
		return obj;
	} 
	
	/**
	 *  
	 * @param queryId
	 * @return
	 */
	public String getQueryById(String queryId) {
		Map queryMap = (Map) getBeanFromFactory("queries"); 
		String query = (String) queryMap.get(queryId); 
		return query; 
	}
}
