package com.travel.service;

import java.util.List;

import com.travel.dao.ITourMasterDAO;
import com.travel.model.TourMaster;
import com.travel.service.common.IGenericService;

public interface ITourMasterService extends IGenericService<TourMaster, Long> {

	void setTourMasterDAO(ITourMasterDAO tourMasterDAO);
	List<TourMaster> findAllToursByDestinationId(Long destinationId) throws Exception ;
	
}
