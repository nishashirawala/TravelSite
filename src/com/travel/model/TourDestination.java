package com.travel.model;

import com.travel.model.common.BaseIdentifiedObject;

@SuppressWarnings("serial")
public class TourDestination extends BaseIdentifiedObject {

	private String destinationName;
	private String destinationDescription;
	private String destinationImage; 

	public String getDestinationImage() {
		return destinationImage;
	}

	public void setDestinationImage(String destinationImage) {
		this.destinationImage = destinationImage;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getDestinationDescription() {
		return destinationDescription;
	}

	public void setDestinationDescription(String destinationDescription) {
		this.destinationDescription = destinationDescription;
	}

}
