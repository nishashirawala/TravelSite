package com.travel.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {

	public HttpServletRequest getHttpServletRequest() {
		ActionContext context = ActionContext.getContext();
		return (HttpServletRequest) context
				.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	}

	public HttpServletResponse getHttpServletResponse() {
		ActionContext context = ActionContext.getContext();
		return (HttpServletResponse) context
				.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
	}

	public ServletContext getServletContext() {
		ActionContext context = ActionContext.getContext();
		return (ServletContext) context
				.get(org.apache.struts2.StrutsStatics.SERVLET_CONTEXT);
	}

}
