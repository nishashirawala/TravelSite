package com.travel.dao;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.TourDestination;

/**
 * Interface for Hotel Master.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ITourDestinationDAO extends IGenericDAO<TourDestination, Long> {
	
	TourDestination findById(Long id) throws Exception;
}