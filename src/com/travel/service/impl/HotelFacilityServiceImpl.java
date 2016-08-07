package com.travel.service.impl;

import java.util.List;

import com.travel.dao.IHotelFacilityDAO;
import com.travel.model.HotelFacility;
import com.travel.service.IHotelFacilityService;
import com.travel.service.common.AbstractService;

public class HotelFacilityServiceImpl extends
		AbstractService<HotelFacility, Long> implements IHotelFacilityService {

	public void setHotelFacilityDAO(IHotelFacilityDAO hotelFacilityDAO) {
		this.genericDAO = hotelFacilityDAO;

	}

	private IHotelFacilityDAO getHotelFacilityDAO() {
		return (IHotelFacilityDAO) this.genericDAO;
	}
	
	public List<HotelFacility> findHotelFacilitiesByHotelMasterId(Long hotelMasterId)throws Exception {
		return getHotelFacilityDAO().findHotelFacilitiesByHotelMasterId(hotelMasterId);
	}

	public HotelFacility findHotelFacilityByMasterIdAndFacilityName(Long hotelMasterId,
			String facilityName) throws Exception {
		return getHotelFacilityDAO().findHotelFacilityByMasterIdAndFacilityName(hotelMasterId, facilityName);
	}
}
