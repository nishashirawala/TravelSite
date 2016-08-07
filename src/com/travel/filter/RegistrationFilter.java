package com.travel.filter;

import org.apache.log4j.Logger;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.travel.service.IUserService;

public class RegistrationFilter extends UsernamePasswordAuthenticationFilter {
	private IUserService userService;

	Logger logger = Logger.getLogger(RegistrationFilter.class);

	/**
	 * @return the userService
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public boolean isNull(String value) {
		if (value == null)
			return true;
		if ("".equals(value.trim()))
			return true;
		return false;
	}
}
