package com.travel.dao;

import java.util.List;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.HotelImages;

/**
 * Interface for Hotel Master.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IHotelImagesDAO extends IGenericDAO<HotelImages, Long> {
	
	HotelImages findById(Long id) throws Exception;
	public List<HotelImages> findHotelImagesByHotelMasterId(Long hotelMasterId) throws Exception; 
}