package com.travel.model;

import com.travel.model.common.BaseIdentifiedObject;

@SuppressWarnings("serial")
public class TourItinerary extends BaseIdentifiedObject {

	private TourMaster tourMaster;
	private String itineraryTitle;
	private String itineraryDescription;
	private String itineraryDay;

	public String getItineraryDay() {
		return itineraryDay;
	}

	public void setItineraryDay(String itineraryDay) {
		this.itineraryDay = itineraryDay;
	}

	public TourMaster getTourMaster() {
		return tourMaster;
	}

	public void setTourMaster(TourMaster tourMaster) {
		this.tourMaster = tourMaster;
	}

	public String getItineraryTitle() {
		return itineraryTitle;
	}

	public void setItineraryTitle(String itineraryTitle) {
		this.itineraryTitle = itineraryTitle;
	}

	public String getItineraryDescription() {
		return itineraryDescription;
	}

	public void setItineraryDescription(String itineraryDescription) {
		this.itineraryDescription = itineraryDescription;
	}

}
