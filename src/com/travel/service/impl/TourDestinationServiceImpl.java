package com.travel.service.impl;

import com.travel.dao.ITourDestinationDAO;
import com.travel.model.TourDestination;
import com.travel.service.ITourDestinationService;
import com.travel.service.common.AbstractService;

public class TourDestinationServiceImpl extends AbstractService<TourDestination, Long> implements ITourDestinationService {

	public void setTourDestinationDAO(ITourDestinationDAO tourDestinationDAO) {
		this.genericDAO = tourDestinationDAO;
		
	}

	@SuppressWarnings("unused")
	private ITourDestinationDAO getTourDestinationDAO() {
		return (ITourDestinationDAO) this.genericDAO;
	}

	
}
