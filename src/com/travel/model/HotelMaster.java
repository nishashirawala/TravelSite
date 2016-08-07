package com.travel.model;

import java.util.HashSet;
import java.util.Set;

import com.travel.model.common.BaseIdentifiedObject;

@SuppressWarnings("serial")
public class HotelMaster extends BaseIdentifiedObject {

	private String hotelName;
	private String hotelDescription;
	private String starRating;
	private String hotelType;
	private String mainImage;
	private String conditions;
	private String otherInformation;
	private Set<HotelImages> hotelImages = new HashSet<HotelImages>(0);

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public String getStarRating() {
		return starRating;
	}

	public void setStarRating(String starRating) {
		this.starRating = starRating;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getOtherInformation() {
		return otherInformation;
	}

	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}

	public Set<HotelImages> getHotelImages() {
		return hotelImages;
	}

	public void setHotelImages(Set<HotelImages> hotelImages) {
		this.hotelImages = hotelImages;
	}

}
