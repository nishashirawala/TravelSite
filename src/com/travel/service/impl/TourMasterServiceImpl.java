package com.travel.service.impl;

import java.util.List;

import com.travel.dao.ITourMasterDAO;
import com.travel.model.TourMaster;
import com.travel.service.ITourMasterService;
import com.travel.service.common.AbstractService;

public class TourMasterServiceImpl extends AbstractService<TourMaster, Long> implements ITourMasterService {

	public void setTourMasterDAO(ITourMasterDAO tourMasterDAO) {
		this.genericDAO = tourMasterDAO;
		
	}

	private ITourMasterDAO getTourMasterDAO() {
		return (ITourMasterDAO) this.genericDAO;
	}
	
	public List<TourMaster> findAllToursByDestinationId(Long destinationId) throws Exception {
		return getTourMasterDAO().findAllToursByDestinationId(destinationId);
	}
	
}
