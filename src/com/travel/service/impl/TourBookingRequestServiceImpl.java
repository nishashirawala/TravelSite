package com.travel.service.impl;

import java.util.List;

import com.travel.dao.ITourBookingRequestDAO;
import com.travel.model.TourBookingRequest;
import com.travel.service.ITourBookingRequestService;
import com.travel.service.common.AbstractService;

public class TourBookingRequestServiceImpl extends
		AbstractService<TourBookingRequest, Long> implements
		ITourBookingRequestService {

	public void setTourBookingRequestDAO(
			ITourBookingRequestDAO tourBookingRequestDAO) {
		this.genericDAO = tourBookingRequestDAO;
	}

	private ITourBookingRequestDAO getTourBookingRequestDAO() {
		return (ITourBookingRequestDAO) this.genericDAO;
	}

	
	public List<TourBookingRequest> findTourBookingInfoByUserId(Long tourId,
			Long userId) throws Exception {
		return getTourBookingRequestDAO().findTourBookingInfoByUserId(tourId, userId);
	}

}
