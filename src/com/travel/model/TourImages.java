package com.travel.model;

import com.travel.model.common.BaseIdentifiedObject;

public class TourImages extends BaseIdentifiedObject{

	private TourMaster tourMaster;
	private String imageSource;
	private String imageDescription;

	public TourMaster getTourMaster() {
		return tourMaster;
	}

	public void setTourMaster(TourMaster tourMaster) {
		this.tourMaster = tourMaster;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

}
