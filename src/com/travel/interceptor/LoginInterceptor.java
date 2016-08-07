package com.travel.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class LoginInterceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		HttpServletRequest httpServletRequest = (HttpServletRequest) context
				.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		HttpSession session = httpServletRequest.getSession();

		if (session != null) {
			Object userNameObj = session.getAttribute("username");
			if (userNameObj != null) {
				return invocation.invoke();
			} else {
				return "user-not-admin";
			}
		} else {
			return "user-not-admin";
		}
	}

}
