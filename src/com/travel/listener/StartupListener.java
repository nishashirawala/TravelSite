package com.travel.listener;


import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

/**
 * StartupListener class used to initialize and database settings and populate
 * any application-wide drop-downs.
 */
public class StartupListener extends ContextLoaderListener {
	
	private static final long serialVersionUID = -4114161599590723244L;
	
	public void contextInitialized(ServletContextEvent event) {
		try {
			super.contextInitialized(event);
		} catch (IllegalStateException ise) {
			ise.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}