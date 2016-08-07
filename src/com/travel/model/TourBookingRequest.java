package com.travel.model;

import com.travel.model.common.BaseIdentifiedObject;

@SuppressWarnings("serial")
public class TourBookingRequest extends BaseIdentifiedObject {

	private TourMaster tourMaster;
	private User user;

	public TourMaster getTourMaster() {
		return tourMaster;
	}

	public void setTourMaster(TourMaster tourMaster) {
		this.tourMaster = tourMaster;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
