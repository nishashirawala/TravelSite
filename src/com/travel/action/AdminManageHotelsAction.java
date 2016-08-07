package com.travel.action;

import java.io.File;
import java.io.IOException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.travel.model.HotelAddress;
import com.travel.model.HotelMaster;
import com.travel.service.IHotelAddressService;
import com.travel.service.IHotelFacilityService;
import com.travel.service.IHotelMasterService;
import com.travel.service.IHotelPolicyService;

@SuppressWarnings("serial")
public class AdminManageHotelsAction extends BaseAction {

	private IHotelMasterService hotelMasterService;
	private IHotelAddressService hotelAddressService;
	private IHotelPolicyService hotelPolicyService;
	private IHotelFacilityService hotelFacilityService;

	private String hotelMasterId;
	private String hotelName;
	private String hotelDescription;
	private String starRating;
	private String hotelType;
	private String mainImage;
	private String conditions;
	private String otherInformation;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private String facilityName;
	private Map<String, String> facilityMap;
	private String facilityDescription;
	private String policyName;
	private String policyDescription;
	private Map<String, String> policyMap;
	private Map<String, String> typeMap;
	private Map<String, String> starRatingMap;
	private File mainImageFile;

	public void getAllHotels() {
		try {
			List<HotelMaster> hotelMasterList = hotelMasterService.findAll();
			JSONArray hotelDetailsArray = new JSONArray();
			for (HotelMaster hotelMaster : hotelMasterList) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("hotelMasterId", hotelMaster.getId());
				jsonObject.put("hotelName", hotelMaster.getHotelName());
				HotelAddress hotelAddress = hotelAddressService
						.findHotelAddressByMasterId(hotelMaster.getId());
				if (hotelAddress != null) {
					String addressLine1 = hotelAddress.getAddressLine1();
					String addressLine2 = hotelAddress.getAddressLine2() != null ? hotelAddress
							.getAddressLine2()
							: "";
					String addressStr = addressLine1 + " " + addressLine2;
					jsonObject.put("hotelAddress", addressStr);
					jsonObject.put("city", hotelAddress.getCity());
					jsonObject.put("state", hotelAddress.getState());
				} else {
					jsonObject.put("hotelAddress", "Not Available");
					jsonObject.put("city", "Not Available");
					jsonObject.put("state", "Not Available");
				}
				String hotelRating = HotelStarRating.valueOf(
						HotelStarRating.class, hotelMaster.getStarRating()).hotelRating;
				String hotelType = HotelType.valueOf(HotelType.class,
						hotelMaster.getHotelType()).hotelType;
				jsonObject.put("hotelType", hotelType);
				jsonObject.put("starRating", hotelRating);
				hotelDetailsArray.put(jsonObject);
			}
			HttpServletResponse httpServletResponse = getHttpServletResponse();
			httpServletResponse.setContentType("application/json");
			httpServletResponse.getWriter().write(hotelDetailsArray.toString());
			httpServletResponse.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String populatePage() {
		try {
			EnumSet<HotelFacility> facilitySet = EnumSet
					.allOf(HotelFacility.class);
			Iterator<HotelFacility> facilityIt = facilitySet.iterator();
			facilityMap = new HashMap<String, String>();
			while (facilityIt.hasNext()) {
				HotelFacility facility = facilityIt.next();
				facilityMap.put(facility.name(), facility.getFacilityName());
			}
			EnumSet<HotelPolicy> policySet = EnumSet.allOf(HotelPolicy.class);
			Iterator<HotelPolicy> policyIt = policySet.iterator();
			policyMap = new HashMap<String, String>();
			while (policyIt.hasNext()) {
				HotelPolicy policy = policyIt.next();
				policyMap.put(policy.name(), policy.getPolicyName());
			}

			EnumSet<HotelType> hotelTypeSet = EnumSet.allOf(HotelType.class);
			Iterator<HotelType> typeIt = hotelTypeSet.iterator();
			typeMap = new HashMap<String, String>();
			while (typeIt.hasNext()) {
				HotelType type = typeIt.next();
				typeMap.put(type.name(), type.getHotelType());
			}

			EnumSet<HotelStarRating> starRatingSet = EnumSet
					.allOf(HotelStarRating.class);
			Iterator<HotelStarRating> ratingIt = starRatingSet.iterator();
			starRatingMap = new HashMap<String, String>();
			while (ratingIt.hasNext()) {
				HotelStarRating rating = ratingIt.next();
				starRatingMap.put(rating.name(), rating.getHotelRating());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void saveMasterInformationForHotel() {
		JSONObject object = new JSONObject();
		HttpServletResponse httpServletResponse = getHttpServletResponse();
		try {
			HotelMaster hotelMaster = null;
			if (hotelMasterId == null || ("-1").equals(hotelMasterId)) {
				hotelMaster = new HotelMaster();
			} else {
				hotelMaster = hotelMasterService.findById(Long
						.parseLong(hotelMasterId));
			}

			hotelMaster.setHotelName(hotelName);
			hotelMaster.setHotelDescription(hotelDescription);
			hotelMaster.setStarRating(starRating);
			hotelMaster.setHotelType(hotelType);
			hotelMaster.setConditions(conditions);
			hotelMaster.setOtherInformation(otherInformation);

			hotelMasterService.saveOrUpdate(hotelMaster);
			setHotelMasterId(String.valueOf(hotelMaster.getId()));
			object.put("response", "success");
			object.put("responseMessage",
					"Hotel Information Saved Successfully");
			object.put("hotelMasterId", hotelMaster.getId());
			httpServletResponse.setContentType("application/json");
			httpServletResponse.getWriter().write(object.toString());
			httpServletResponse.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
			setHotelMasterId("-1");
			object.put("response", "error");
			object.put("responseMessage",
					"Error While Saving Hotel Information.");
			object.put("hotelMasterId", "-1");
			httpServletResponse.setContentType("application/json");
			try {
				httpServletResponse.getWriter().write(object.toString());
				httpServletResponse.flushBuffer();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void saveAddressInformationForHotel() {
		JSONObject object = new JSONObject();
		HttpServletResponse httpServletResponse = getHttpServletResponse();
		try {
			if (hotelMasterId != null && !("-1").equals(hotelMasterId)) {
				HotelMaster hotelMaster = hotelMasterService.findById(Long
						.parseLong(hotelMasterId));
				HotelAddress hotelAddress = hotelAddressService
						.findHotelAddressByMasterId(Long
								.parseLong(hotelMasterId));
				if (hotelAddress == null) {
					hotelAddress = new HotelAddress();
				}
				hotelAddress.setHotelMaster(hotelMaster);
				hotelAddress.setAddressLine1(addressLine1);
				hotelAddress.setAddressLine2(addressLine2);
				hotelAddress.setCity(city);
				hotelAddress.setState(state);
				hotelAddress.setPostalCode(postalCode);
				hotelAddress.setCountry(country);

				hotelAddressService.saveOrUpdate(hotelAddress);
				object.put("response", "success");
				object.put("responseMessage",
						"Hotel Address Saved Successfully");

			} else {
				object.put("response", "error");
				object.put("responseMessage",
						"Error while saving hotel address");
			}
			httpServletResponse.setContentType("application/json");
			httpServletResponse.getWriter().write(object.toString());
			httpServletResponse.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
			object.put("response", "error");
			object.put("responseMessage", "Error While Saving Hotel Address.");
			object.put("hotelMasterId", "-1");
			httpServletResponse.setContentType("application/json");
			try {
				httpServletResponse.getWriter().write(object.toString());
				httpServletResponse.flushBuffer();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void savePolicyInformationForHotel() {
		JSONObject object = new JSONObject();
		HttpServletResponse httpServletResponse = getHttpServletResponse();
		try {
			if (hotelMasterId != null && !("-1").equals(hotelMasterId)) {
				HotelMaster hotelMaster = hotelMasterService.findById(Long
						.parseLong(hotelMasterId));
				com.travel.model.HotelPolicy policy = hotelPolicyService
						.findHotelPolicyByMasterIdAndPolicyName(Long
								.parseLong(hotelMasterId), policyName);

				if (policy == null) {
					policy = new com.travel.model.HotelPolicy();
				}
				policy.setPolicyName(policyName);
				policy.setPolicyDescription(policyDescription);
				policy.setHotelMaster(hotelMaster);
				hotelPolicyService.saveOrUpdate(policy);
				object.put("response", "success");
				object
						.put("responseMessage",
								"Hotel Policy Saved Successfully");

			} else {
				object.put("response", "error");
				object
						.put("responseMessage",
								"Error While Saving Hotel Policy");
			}
			httpServletResponse.setContentType("application/json");
			httpServletResponse.getWriter().write(object.toString());
			httpServletResponse.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
			object.put("response", "error");
			object.put("responseMessage", "Error While Saving Hotel Policy.");
			object.put("hotelMasterId", "-1");
			httpServletResponse.setContentType("application/json");
			try {
				httpServletResponse.getWriter().write(object.toString());
				httpServletResponse.flushBuffer();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void getSelectedPolicyInformationForHotel() {
		JSONObject object = new JSONObject();
		HttpServletResponse httpServletResponse = getHttpServletResponse();
		try {
			if (hotelMasterId != null && !("-1").equals(hotelMasterId)) {
				com.travel.model.HotelPolicy policy = hotelPolicyService
						.findHotelPolicyByMasterIdAndPolicyName(Long
								.parseLong(hotelMasterId), policyName);
				if (policy != null) {
					object.put("policyDesc", policy.getPolicyDescription());
				} else {
					object.put("policyDesc", "");
				}

			} else {
				object.put("policyDesc", "");
			}
			httpServletResponse.setContentType("application/json");
			httpServletResponse.getWriter().write(object.toString());
			httpServletResponse.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
			object.put("policyDesc", "");
			httpServletResponse.setContentType("application/json");
			try {
				httpServletResponse.getWriter().write(object.toString());
				httpServletResponse.flushBuffer();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void saveFacilityInformationForHotel() {
		JSONObject object = new JSONObject();
		HttpServletResponse httpServletResponse = getHttpServletResponse();
		try {
			if (hotelMasterId != null && !("-1").equals(hotelMasterId)) {
				HotelMaster hotelMaster = hotelMasterService.findById(Long
						.parseLong(hotelMasterId));
				com.travel.model.HotelFacility facility = hotelFacilityService
						.findHotelFacilityByMasterIdAndFacilityName(Long
								.parseLong(hotelMasterId), facilityName);

				if (facility == null) {
					facility = new com.travel.model.HotelFacility();
				}
				facility.setFacilityName(facilityName);
				facility.setFacilityDescription(facilityDescription);
				facility.setHotelMaster(hotelMaster);
				hotelFacilityService.saveOrUpdate(facility);
				object.put("response", "success");
				object.put("responseMessage",
						"Hotel Facility Saved Successfully");

			} else {
				object.put("response", "error");
				object.put("responseMessage",
						"Error While Saving Hotel Facility");
			}
			httpServletResponse.setContentType("application/json");
			httpServletResponse.getWriter().write(object.toString());
			httpServletResponse.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
			object.put("response", "error");
			object.put("responseMessage", "Error While Saving Hotel Facility.");
			object.put("hotelMasterId", "-1");
			httpServletResponse.setContentType("application/json");
			try {
				httpServletResponse.getWriter().write(object.toString());
				httpServletResponse.flushBuffer();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void getSelectedFacilityInformationForHotel() {
		JSONObject object = new JSONObject();
		HttpServletResponse httpServletResponse = getHttpServletResponse();
		try {
			if (hotelMasterId != null && !("-1").equals(hotelMasterId)) {
				com.travel.model.HotelFacility facility = hotelFacilityService
						.findHotelFacilityByMasterIdAndFacilityName(Long
								.parseLong(hotelMasterId), facilityName);
				if (facility != null) {
					object.put("facilityDesc", facility
							.getFacilityDescription());
				} else {
					object.put("facilityDesc", "");
				}

			} else {
				object.put("facilityDesc", "");
			}
			httpServletResponse.setContentType("application/json");
			httpServletResponse.getWriter().write(object.toString());
			httpServletResponse.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
			object.put("facilityDesc", "");
			httpServletResponse.setContentType("application/json");
			try {
				httpServletResponse.getWriter().write(object.toString());
				httpServletResponse.flushBuffer();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public String showInformationForHotel() {
		try {
			if (hotelMasterId != null) {
				HotelMaster hotelMaster = hotelMasterService.findById(Long
						.parseLong(hotelMasterId));
				setHotelMasterId(hotelMasterId);
				setHotelName(hotelMaster.getHotelName());
				setHotelDescription(hotelMaster.getHotelDescription());
				setHotelType(hotelMaster.getHotelType());
				setStarRating(hotelMaster.getStarRating());
				setConditions(hotelMaster.getConditions());
				setOtherInformation(hotelMaster.getOtherInformation());

				HotelAddress hotelAddress = hotelAddressService
						.findHotelAddressByMasterId(Long
								.parseLong(hotelMasterId));
				if (hotelAddress != null) {
					setAddressLine1(hotelAddress.getAddressLine1());
					setAddressLine2(hotelAddress.getAddressLine2());
					setCity(hotelAddress.getCity());
					setState(hotelAddress.getState());
					setCountry(hotelAddress.getCountry());
					setPostalCode(hotelAddress.getPostalCode());
				}
				List<com.travel.model.HotelPolicy> policyList = hotelPolicyService
						.findHotelPoliciesByHotelMasterId(Long
								.parseLong(hotelMasterId));
				if (policyList != null && policyList.size() > 0) {
					com.travel.model.HotelPolicy policy = policyList.get(0);
					setPolicyName(policy.getPolicyName());
					setPolicyDescription(policy.getPolicyDescription());
				}
				List<com.travel.model.HotelFacility> facilityList = hotelFacilityService
						.findHotelFacilitiesByHotelMasterId(Long
								.parseLong(hotelMasterId));
				if (facilityList != null && facilityList.size() > 0) {
					com.travel.model.HotelFacility facility = facilityList
							.get(0);
					setFacilityName(facility.getFacilityName());
					setFacilityDescription(facility.getFacilityDescription());
				}
				return populatePage();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public enum HotelFacility {
		general("General"), activities("Activities"), services("Servicies"), internet(
				"Internet"), parking("Guest Parking");
		private String facilityName;

		private HotelFacility(String name) {
			this.facilityName = name;
		}

		public String getFacilityName() {
			return facilityName;
		}
	}

	public enum HotelPolicy {
		checkin("Check In"), checkout("Check Out"), pets("Pets"), creditcards(
				"Accepted Credit Cards"), importantinformation(
				"Important Information"), groups("Groups");
		private String policyName;

		private HotelPolicy(String name) {
			this.policyName = name;
		}

		public String getPolicyName() {
			return policyName;
		}
	}

	public enum HotelType {
		economy("Economy"), budget("Budget"), luxury("Luxury");
		private String hotelType;

		private HotelType(String name) {
			this.hotelType = name;
		}

		public String getHotelType() {
			return hotelType;
		}
	}

	public enum HotelStarRating {
		none("Not Rated"), onestar("1 Star"), twostar("2 Star"), threestar(
				"3 Star"), fourstar("4 Star"), fivestar("5 Star"), sevenstar(
				"7 Star");
		private String hotelRating;

		private HotelStarRating(String name) {
			this.hotelRating = name;
		}

		public String getHotelRating() {
			return hotelRating;
		}
	}

	public void setHotelMasterService(IHotelMasterService hotelMasterService) {
		this.hotelMasterService = hotelMasterService;
	}

	public void setHotelAddressService(IHotelAddressService hotelAddressService) {
		this.hotelAddressService = hotelAddressService;
	}

	public void setHotelPolicyService(IHotelPolicyService hotelPolicyService) {
		this.hotelPolicyService = hotelPolicyService;
	}

	public void setHotelFacilityService(
			IHotelFacilityService hotelFacilityService) {
		this.hotelFacilityService = hotelFacilityService;
	}

	public String getHotelMasterId() {
		return hotelMasterId;
	}

	public void setHotelMasterId(String hotelMasterId) {
		this.hotelMasterId = hotelMasterId;
	}

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

	public Map<String, String> getFacilityMap() {
		return facilityMap;
	}

	public void setFacilityMap(Map<String, String> facilityMap) {
		this.facilityMap = facilityMap;
	}

	public Map<String, String> getPolicyMap() {
		return policyMap;
	}

	public void setPolicyMap(Map<String, String> policyMap) {
		this.policyMap = policyMap;
	}

	public Map<String, String> getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(Map<String, String> typeMap) {
		this.typeMap = typeMap;
	}

	public Map<String, String> getStarRatingMap() {
		return starRatingMap;
	}

	public void setStarRatingMap(Map<String, String> starRatingMap) {
		this.starRatingMap = starRatingMap;
	}

	public File getMainImageFile() {
		return mainImageFile;
	}

	public void setMainImageFile(File mainImageFile) {
		this.mainImageFile = mainImageFile;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
