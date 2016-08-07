package com.travel.service.impl;

import java.util.List;

import com.travel.dao.ITourImagesDAO;
import com.travel.model.TourImages;
import com.travel.service.ITourImagesService;
import com.travel.service.common.AbstractService;

public class TourImagesServiceImpl extends AbstractService<TourImages, Long>
		implements ITourImagesService {

	public void setTourImagesDAO(ITourImagesDAO tourImagesDAO) {
		this.genericDAO = tourImagesDAO;

	}

	private ITourImagesDAO getTourImagesDAO() {
		return (ITourImagesDAO) this.genericDAO;
	}

	public List<TourImages> findImagesByTourMasterId(Long tourId) throws Exception{
		return getTourImagesDAO().findImagesByTourMasterId(tourId);
	}
}
