package com.travel.dao;

import java.util.List;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.TourBookingRequest;

public interface ITourBookingRequestDAO extends IGenericDAO<TourBookingRequest, Long> {

	public List<TourBookingRequest> findTourBookingInfoByUserId(Long tourId, Long userId) throws Exception;
}