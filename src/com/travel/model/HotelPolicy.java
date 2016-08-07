package com.travel.model;

import com.travel.model.common.BaseIdentifiedObject;

@SuppressWarnings("serial")
public class HotelPolicy extends BaseIdentifiedObject {

	private HotelMaster hotelMaster;
	private String policyName;
	private String policyDescription;

	public HotelMaster getHotelMaster() {
		return hotelMaster;
	}

	public void setHotelMaster(HotelMaster hotelMaster) {
		this.hotelMaster = hotelMaster;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyDescription() {
		return policyDescription;
	}

	public void setPolicyDescription(String policyDescription) {
		this.policyDescription = policyDescription;
	}

}
