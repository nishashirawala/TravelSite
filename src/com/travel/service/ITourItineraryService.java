package com.travel.service;

import java.util.List;

import com.travel.dao.ITourItineraryDAO;
import com.travel.model.TourItinerary;
import com.travel.service.common.IGenericService;

public interface ITourItineraryService extends IGenericService<TourItinerary, Long> {

	void setTourItineraryDAO(ITourItineraryDAO tourItineraryDAO);
	List<TourItinerary> findByTourMasterId(Long tourMasterId) throws Exception;
	TourItinerary findByTourMasterIdAndDay(Long tourMasterId, String itineraryDay) throws Exception;
}
