package com.travel.model;

import com.travel.model.common.BaseIdentifiedObject;

@SuppressWarnings("serial")
public class HotelBookingRequest extends BaseIdentifiedObject {

	private HotelMaster hotelMaster;
	private User user;

	public HotelMaster getHotelMaster() {
		return hotelMaster;
	}

	public void setHotelMaster(HotelMaster hotelMaster) {
		this.hotelMaster = hotelMaster;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
