package com.travel.dao;

import java.util.List;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.HotelFacility;

/**
 * Interface for Hotel Master.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IHotelFacilityDAO extends IGenericDAO<HotelFacility, Long> {

	HotelFacility findById(Long id) throws Exception;

	List<HotelFacility> findHotelFacilitiesByHotelMasterId(Long hotelMasterId)
			throws Exception;

	HotelFacility findHotelFacilityByMasterIdAndFacilityName(
			Long hotelMasterId, String facilityName) throws Exception;
}