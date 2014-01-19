package com.ccbill.cinema.component;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * This class describes the Application Context Provider
 * @author luca martini
 * @category component
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext context = null;
	private static final Logger log = Logger.getLogger(ApplicationContextProvider.class);
	
	/** Returns the application context
	 * @name getContext
	 * @since 1.0.0
	 * @version 1.0.0
	 * @author luca martini
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {				
		log.info("#----@@@@@ Retrieving the application context @@@@@----#");
		if (context != null) {
			return context;
		} else {
			log.error("#----%%%%% The Spring application context is not yet available %%%%%----#");
			throw new IllegalStateException("#----%%%%% The Spring application context is not yet available %%%%%----#");
		}
	}

	/** Set the application context
	 * @name setApplicationContext
	 * @since 1.0.0
	 * @version 1.0.0
	 * @author luca martini
	 */
	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		log.info("#----@@@@@ Setting the application context @@@@@----#");
		if (context == null) {
			context = applicationContext;
		} else {
			log.error("#----%%%%% The application context provider was already initialized. %%%%%----#");
			throw new IllegalStateException("#----%%%%% The application context provider was already initialized. %%%%%----#");
		}
	}
}