package com.travel.dao;

import java.util.List;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.TourItinerary;

/**
 * Interface for Hotel Master.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ITourItineraryDAO extends IGenericDAO<TourItinerary, Long> {
	
	TourItinerary findById(Long id) throws Exception;
	List<TourItinerary> findByTourMasterId(Long tourMasterId) throws Exception;
	TourItinerary findByTourMasterIdAndDay(Long tourMasterId, String itineraryDay) throws Exception;
}