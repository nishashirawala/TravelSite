package com.travel.dao;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.HotelMaster;

/**
 * Interface for Hotel Master.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IHotelMasterDAO extends IGenericDAO<HotelMaster, Long> {
	
	HotelMaster findById(Long id) throws Exception;
}