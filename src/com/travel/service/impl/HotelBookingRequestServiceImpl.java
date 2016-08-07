package com.travel.service.impl;

import java.util.List;

import com.travel.dao.IHotelBookingRequestDAO;
import com.travel.model.HotelBookingRequest;
import com.travel.service.IHotelBookingRequestService;
import com.travel.service.common.AbstractService;

public class HotelBookingRequestServiceImpl extends
		AbstractService<HotelBookingRequest, Long> implements
		IHotelBookingRequestService {

	public void setHotelBookingRequestDAO(
			IHotelBookingRequestDAO hotelBookingRequestDAO) {
		this.genericDAO = hotelBookingRequestDAO;
	}

	private IHotelBookingRequestDAO getHotelBookingRequestDAO() {
		return (IHotelBookingRequestDAO) this.genericDAO;
	}

	
	public List<HotelBookingRequest> findHotelBookingInfoByUserId(Long hotelId,
			Long userId) throws Exception {
		return getHotelBookingRequestDAO().findHotelBookingInfoByUserId(hotelId, userId);
	}

}
