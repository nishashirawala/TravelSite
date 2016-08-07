package com.travel.model;

import com.travel.model.common.BaseIdentifiedObject;

@SuppressWarnings("serial")
public class HotelFacility extends BaseIdentifiedObject {

	private HotelMaster hotelMaster;
	private String facilityName;
	private String facilityDescription;

	public HotelMaster getHotelMaster() {
		return hotelMaster;
	}

	public void setHotelMaster(HotelMaster hotelMaster) {
		this.hotelMaster = hotelMaster;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getFacilityDescription() {
		return facilityDescription;
	}

	public void setFacilityDescription(String facilityDescription) {
		this.facilityDescription = facilityDescription;
	}

}
