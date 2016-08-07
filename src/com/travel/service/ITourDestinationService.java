package com.travel.service;

import com.travel.dao.ITourDestinationDAO;
import com.travel.model.TourDestination;
import com.travel.service.common.IGenericService;

public interface ITourDestinationService extends IGenericService<TourDestination, Long> {

	void setTourDestinationDAO(ITourDestinationDAO tourDestinationDAO);

	
}
