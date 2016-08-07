package com.travel.security.extended;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	public static final String SPRING_SECURITY_LAST_USERNAME_KEY = "SPRING_SECURITY_LAST_USERNAME";

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		Object obj = exception.getExtraInformation();
		if (obj instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) obj;
			request.getSession().setAttribute(SPRING_SECURITY_LAST_USERNAME_KEY, userDetails.getUsername());
		}
		super.onAuthenticationFailure(request, response, exception);
	}

}
