package com.travel.dao;

import java.util.List;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.TourMaster;

/**
 * Interface for Hotel Master.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ITourMasterDAO extends IGenericDAO<TourMaster, Long> {

	TourMaster findById(Long id) throws Exception;

	List<TourMaster> findAllToursByDestinationId(Long destinationId)
			throws Exception;
}