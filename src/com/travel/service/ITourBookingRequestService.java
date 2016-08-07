package com.travel.service;

import java.util.List;

import com.travel.dao.ITourBookingRequestDAO;
import com.travel.model.TourBookingRequest;
import com.travel.service.common.IGenericService;

public interface ITourBookingRequestService extends
		IGenericService<TourBookingRequest, Long> {

	void setTourBookingRequestDAO(ITourBookingRequestDAO tourBookingRequestDAO);
	List<TourBookingRequest> findTourBookingInfoByUserId(Long tourId, Long userId) throws Exception;
}
