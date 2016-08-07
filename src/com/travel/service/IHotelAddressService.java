package com.travel.service;

import com.travel.dao.IHotelAddressDAO;
import com.travel.model.HotelAddress;
import com.travel.service.common.IGenericService;

public interface IHotelAddressService extends
		IGenericService<HotelAddress, Long> {

	void setHotelAddressDAO(IHotelAddressDAO hotelAddressDAO);

	HotelAddress findHotelAddressByMasterId(Long hotelMasterId) throws Exception;
}
