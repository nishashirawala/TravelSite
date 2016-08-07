package com.travel.action;

import java.util.List;

import com.travel.model.TourMaster;
import com.travel.service.ITourMasterService;

public class HomePageAction extends BaseAction {

	ITourMasterService tourMasterService;

	List<TourMaster> allTours;

	public String showPopularTours() {
		try {
			List<TourMaster> tourMasterList = tourMasterService.findAll();
			if (tourMasterList != null && tourMasterList.size() > 0) {
				for (TourMaster tourMaster : tourMasterList) {
					String imageSavePath = "images//Tours//"+ String.valueOf(tourMaster.getId());
					String mImage = tourMaster.getMainImage();
					tourMaster.setMainImage(imageSavePath + "//" + mImage);
				}
				setAllTours(tourMasterList);
			}

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public List<TourMaster> getAllTours() {
		return allTours;
	}

	public void setAllTours(List<TourMaster> allTours) {
		this.allTours = allTours;
	}

	public void setTourMasterService(ITourMasterService tourMasterService) {
		this.tourMasterService = tourMasterService;
	}
}
