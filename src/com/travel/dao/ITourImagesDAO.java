package com.travel.dao;

import java.util.List;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.TourImages;

/**
 * Interface for Hotel Master.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ITourImagesDAO extends IGenericDAO<TourImages, Long> {
	
	TourImages findById(Long id) throws Exception;
	List<TourImages> findImagesByTourMasterId(Long tourId) throws Exception;
}