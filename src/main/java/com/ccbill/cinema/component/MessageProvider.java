package com.ccbill.cinema.component;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 
@Component
@Scope("singleton")
public class MessageProvider {	
	private static final Logger log = Logger.getLogger(MessageProvider.class);
	
	/** Returns a message from bundle resource
	 * @name getMessage
	 * @since 1.0.0
	 * @version 1.0.0
	 * @param key
	 * @return String message
	 */
	public static String getMessage(String key) {
        try {
            MessageSource bean = ApplicationContextProvider.getApplicationContext().getBean(MessageSource.class);
            return bean.getMessage(key, null, Locale.UK);
        } catch (Exception e) {
        	log.error("Unresolved key: " + key);
            return "Unresolved key: " + key;
        }
	}
	
	/** Returns a parametrized message from bundle resource
	 * @name getBindedMessage
	 * @since 1.0.0
	 * @version 1.0.0
	 * @param key
	 * @param args
	 * @return String message
	 */
    public static String getBindedMessage(String key, Object[] args) {
        try {
            MessageSource bean = ApplicationContextProvider.getApplicationContext().getBean(MessageSource.class);
            return bean.getMessage(key, args, Locale.UK);
        }
        catch (Exception e) {
        	log.error("Unresolved key: " + key);
            return "Unresolved key: " + key;
        }
    }
}
