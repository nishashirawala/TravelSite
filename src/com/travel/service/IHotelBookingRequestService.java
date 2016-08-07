package com.travel.service;

import java.util.List;

import com.travel.dao.IHotelBookingRequestDAO;
import com.travel.model.HotelBookingRequest;
import com.travel.service.common.IGenericService;

public interface IHotelBookingRequestService extends
		IGenericService<HotelBookingRequest, Long> {

	void setHotelBookingRequestDAO(IHotelBookingRequestDAO hotelBookingRequestDAO);
	List<HotelBookingRequest> findHotelBookingInfoByUserId(Long hotelId, Long userId) throws Exception;
}
