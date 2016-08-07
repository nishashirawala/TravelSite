package com.travel.service;

import com.travel.dao.IHotelMasterDAO;
import com.travel.model.HotelMaster;
import com.travel.service.common.IGenericService;

public interface IHotelMasterService extends IGenericService<HotelMaster, Long> {

	void setHotelMasterDAO(IHotelMasterDAO hotelMasterDAO);

	
}
