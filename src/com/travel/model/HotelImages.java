package com.travel.model;

import com.travel.model.common.BaseIdentifiedObject;

@SuppressWarnings("serial")
public class HotelImages extends BaseIdentifiedObject {

	private HotelMaster hotelMaster;
	private String imageFile;
	private String imageDescription;

	public HotelMaster getHotelMaster() {
		return hotelMaster;
	}

	public void setHotelMaster(HotelMaster hotelMaster) {
		this.hotelMaster = hotelMaster;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}
}
