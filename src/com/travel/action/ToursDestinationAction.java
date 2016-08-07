package com.travel.action;

import java.util.ArrayList;
import java.util.List;

import com.travel.model.TourDestination;
import com.travel.service.ITourDestinationService;
import com.travel.service.ITourImagesService;
import com.travel.service.ITourItineraryService;
import com.travel.service.ITourMasterService;

public class ToursDestinationAction extends BaseAction {

	ITourMasterService tourMasterService;
	ITourDestinationService tourDestinationService;
	ITourItineraryService tourItineraryService;
	ITourImagesService tourImagesService;

	private String tourDestinationId;
	private List<TourDestination> tourDestinationList;

	public String showAllTourDestinationInfo() {
		try {
			
			List<TourDestination> tourDestinationList = tourDestinationService.findAll();
			List<TourDestination> tempList = new ArrayList<TourDestination>();
			for (TourDestination tourDestination : tourDestinationList) {
				String imageSavePath = "images//TourDestinations";
				tourDestination.setDestinationImage(imageSavePath + "//" + tourDestination.getId() + ".jpg");
				tempList.add(tourDestination);
			}
			setTourDestinationList(tempList);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String displayTourDetails() {
		return SUCCESS;
	}


	public String getTourDestinationId() {
		return tourDestinationId;
	}

	public void setTourDestinationId(String tourDestinationId) {
		this.tourDestinationId = tourDestinationId;
	}

	public List<TourDestination> getTourDestinationList() {
		return tourDestinationList;
	}

	public void setTourDestinationList(List<TourDestination> tourDestinationList) {
		this.tourDestinationList = tourDestinationList;
	}

	public void setTourMasterService(ITourMasterService tourMasterService) {
		this.tourMasterService = tourMasterService;
	}

	public void setTourDestinationService(
			ITourDestinationService tourDestinationService) {
		this.tourDestinationService = tourDestinationService;
	}

	public void setTourItineraryService(
			ITourItineraryService tourItineraryService) {
		this.tourItineraryService = tourItineraryService;
	}

	public void setTourImagesService(ITourImagesService tourImagesService) {
		this.tourImagesService = tourImagesService;
	}
}
