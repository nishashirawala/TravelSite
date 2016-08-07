package com.travel.dao;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.HotelAddress;

/**
 * Interface for Hotel Master.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IHotelAddressDAO extends IGenericDAO<HotelAddress, Long> {
	
	HotelAddress findById(Long id) throws Exception;
	HotelAddress findByHotelByMasterId(Long hotelMasterId) throws Exception;
}