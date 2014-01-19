package com.ccbill.cinema.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * This class contains the Cors filter hook
 * @author luca martini
 * @category configuration
 * @version 1.0.0
 * @since 1.0.0
 */
public class CorsFilter extends OncePerRequestFilter {
	
	/** This hook execute the doFilterInternal for attaching right HTTP headers for rest
	 * @name doFilterInternal
	 * @since 1.0.0
	 * @version 1.0.0
	 * @author luca martini
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
			// CORS "pre-flight" request
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "X-Requested-With, Origin, Accept, Content-Type");
			response.addHeader("Access-Control-Max-Age", "1800");
		}
		
		filterChain.doFilter(request, response);
	}
}
