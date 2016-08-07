package com.travel.service.impl;

import java.util.List;

import com.travel.dao.IHotelImagesDAO;
import com.travel.model.HotelImages;
import com.travel.service.IHotelImagesService;
import com.travel.service.common.AbstractService;

public class HotelImagesServiceImpl extends
		AbstractService<HotelImages, Long> implements IHotelImagesService {

	public void setHotelImagesDAO(IHotelImagesDAO hotelImagesDAO) {
		this.genericDAO = hotelImagesDAO;

	}

	@SuppressWarnings("unused")
	private IHotelImagesDAO getHotelImagesDAO() {
		return (IHotelImagesDAO) this.genericDAO;
	}

	public List<HotelImages> findHotelImagesByHotelMasterId(Long hotelMasterId)	throws Exception {
		return getHotelImagesDAO().findHotelImagesByHotelMasterId(hotelMasterId);
	}
}
