package com.travel.service.impl;

import com.travel.dao.IHotelMasterDAO;
import com.travel.model.HotelMaster;
import com.travel.service.IHotelMasterService;
import com.travel.service.common.AbstractService;

public class HotelMasterServiceImpl extends AbstractService<HotelMaster, Long> implements IHotelMasterService {

	public void setHotelMasterDAO(IHotelMasterDAO hotelMasterDAO) {
		this.genericDAO = hotelMasterDAO;
		
	}

	@SuppressWarnings("unused")
	private IHotelMasterDAO getHotelMasterDAO() {
		return (IHotelMasterDAO) this.genericDAO;
	}

	
}
