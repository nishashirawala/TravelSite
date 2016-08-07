package com.travel.security.extended;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.travel.model.User;
import com.travel.service.IUserService;

public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private IUserService userService;

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		try {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			if (userDetails != null) {
				String userName = userDetails.getUsername();
				User user = userService.findUserByUserName(userName);
				if (user != null) {
					request.getSession().setAttribute("username", user.getUserName());
					request.getSession().setAttribute("name", user.getFirstName() + " " + user.getLastName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		super.onAuthenticationSuccess(request, response, authentication);
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
