package com.travel.service.impl;

import com.travel.dao.IHotelAddressDAO;
import com.travel.model.HotelAddress;
import com.travel.service.IHotelAddressService;
import com.travel.service.common.AbstractService;

public class HotelAddressServiceImpl extends
		AbstractService<HotelAddress, Long> implements IHotelAddressService {

	public void setHotelAddressDAO(IHotelAddressDAO hotelAddressDAO) {
		this.genericDAO = hotelAddressDAO;

	}

	private IHotelAddressDAO getHotelAddressDAO() {
		return (IHotelAddressDAO) this.genericDAO;
	}

	public HotelAddress findHotelAddressByMasterId(Long hotelMasterId)
			throws Exception {
		return getHotelAddressDAO().findByHotelByMasterId(hotelMasterId);
	}

}
