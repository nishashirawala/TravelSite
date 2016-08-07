package com.travel.service;

import java.util.List;

import com.travel.dao.IHotelImagesDAO;
import com.travel.model.HotelImages;
import com.travel.service.common.IGenericService;

public interface IHotelImagesService extends IGenericService<HotelImages, Long> {

	void setHotelImagesDAO(IHotelImagesDAO hotelImagesDAO);

	public List<HotelImages> findHotelImagesByHotelMasterId(Long hotelMasterId)	throws Exception;
}
