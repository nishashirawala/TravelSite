package com.travel.dao;

import java.util.List;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.HotelBookingRequest;

public interface IHotelBookingRequestDAO extends IGenericDAO<HotelBookingRequest, Long> {

	public List<HotelBookingRequest> findHotelBookingInfoByUserId(Long hotelId, Long userId) throws Exception;
}