package com.travel.service;

import java.util.List;

import com.travel.dao.ITourImagesDAO;
import com.travel.model.TourImages;
import com.travel.service.common.IGenericService;

public interface ITourImagesService extends IGenericService<TourImages, Long> {

	void setTourImagesDAO(ITourImagesDAO tourImagesDAO);

	List<TourImages> findImagesByTourMasterId(Long tourId) throws Exception;
}
