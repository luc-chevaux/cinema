package com.ccbill.cinema.configuration;

import javax.annotation.PostConstruct;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * This class describes the Jackson Object Mapper
 * @author luca martini
 * @category configuration
 * @version 1.0.0
 * @since 1.0.0
 */

public class JacksonObjectMapper extends ObjectMapper {
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
}
