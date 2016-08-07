package com.travel.service.impl;

import java.util.List;

import com.travel.dao.ITourItineraryDAO;
import com.travel.model.TourItinerary;
import com.travel.service.ITourItineraryService;
import com.travel.service.common.AbstractService;

public class TourItineraryServiceImpl extends
		AbstractService<TourItinerary, Long> implements ITourItineraryService {

	public void setTourItineraryDAO(ITourItineraryDAO tourItineraryDAO) {
		this.genericDAO = tourItineraryDAO;

	}

	private ITourItineraryDAO getTourItineraryDAO() {
		return (ITourItineraryDAO) this.genericDAO;
	}

	public List<TourItinerary> findByTourMasterId(Long tourMasterId) throws Exception {
		return getTourItineraryDAO().findByTourMasterId(tourMasterId);
	}

	public TourItinerary findByTourMasterIdAndDay(Long tourMasterId,
			String itineraryDay) throws Exception {
		return getTourItineraryDAO().findByTourMasterIdAndDay(tourMasterId, itineraryDay);
	}
}
