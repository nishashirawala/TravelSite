package com.travel.model;

import com.travel.model.common.BaseIdentifiedObject;

@SuppressWarnings("serial")
public class TourMaster extends BaseIdentifiedObject {

	private TourDestination tourDestination;
	private String tourName;
	private String tourDescription;
	private String tourPrice;
	private String tourDates;
	private String mainImage;

	public TourDestination getTourDestination() {
		return tourDestination;
	}

	public void setTourDestination(TourDestination tourDestination) {
		this.tourDestination = tourDestination;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getTourDescription() {
		return tourDescription;
	}

	public void setTourDescription(String tourDescription) {
		this.tourDescription = tourDescription;
	}

	public String getTourPrice() {
		return tourPrice;
	}

	public void setTourPrice(String tourPrice) {
		this.tourPrice = tourPrice;
	}

	public String getTourDates() {
		return tourDates;
	}

	public void setTourDates(String tourDates) {
		this.tourDates = tourDates;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

}
