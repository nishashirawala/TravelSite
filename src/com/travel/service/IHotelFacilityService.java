package com.travel.service;

import java.util.List;

import com.travel.dao.IHotelFacilityDAO;
import com.travel.model.HotelFacility;
import com.travel.service.common.IGenericService;

public interface IHotelFacilityService extends IGenericService<HotelFacility, Long> {

	void setHotelFacilityDAO(IHotelFacilityDAO hotelFacilityDAO);

	List<HotelFacility> findHotelFacilitiesByHotelMasterId(Long hotelMasterId)throws Exception;
	
	HotelFacility findHotelFacilityByMasterIdAndFacilityName(Long hotelMasterId,
			String facilityName) throws Exception;
}
