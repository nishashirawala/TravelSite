package com.travel.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.travel.model.HotelAddress;
import com.travel.model.HotelBookingRequest;
import com.travel.model.HotelFacility;
import com.travel.model.HotelImages;
import com.travel.model.HotelMaster;
import com.travel.model.HotelPolicy;
import com.travel.model.User;
import com.travel.service.IHotelAddressService;
import com.travel.service.IHotelBookingRequestService;
import com.travel.service.IHotelFacilityService;
import com.travel.service.IHotelImagesService;
import com.travel.service.IHotelMasterService;
import com.travel.service.IHotelPolicyService;
import com.travel.service.IUserService;

public class HotelsPageAction extends BaseAction {

	private IHotelMasterService hotelMasterService;
	private IHotelImagesService hotelImagesService;
	private IHotelFacilityService hotelFacilityService;
	private IHotelPolicyService hotelPolicyService;
	private IHotelAddressService hotelAddressService;
	IHotelBookingRequestService hotelBookingRequestService;
	IUserService userService;

	private String hotelMasterId;
	private String hotelName;
	private String hotelDescription;
	private String starRating;
	private String hotelType;
	private String conditions;
	private String otherInformation;
	private String hotelAddress;
	private String hotelMainImage;
	List<HotelImages> hotelImages;
	List<HotelPolicy> hotelPolicyList;
	List<HotelFacility> hotelFaclityList;

	public void showAllHotelsInfo() {
		try {
			List<HotelMaster> hotelMasterList = hotelMasterService.findAll();
			JSONArray hotelDetailsArray = new JSONArray();
			for (HotelMaster hotelMaster : hotelMasterList) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("hotelMasterId", hotelMaster.getId());
				jsonObject.put("hotelName", hotelMaster.getHotelName());
				jsonObject.put("hotelType", hotelMaster.getHotelType());
				jsonObject.put("hotelStarRating", hotelMaster.getStarRating());
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

	public String displayHotelsDetails() {
		try {
			HotelMaster hotelMaster = null;
			HttpSession session = getHttpServletRequest().getSession();
			if (session.getAttribute("memberusername") != null
					&& session.getAttribute("hotelIdForBooking") != null) {
				hotelMasterId = (String) session
						.getAttribute("hotelIdForBooking");
				String memberUserName = (String) session
						.getAttribute("memberusername");
				if (hotelMasterId != null && !"".equals(hotelMasterId)) {
					hotelMaster = hotelMasterService.findById(Long
							.parseLong(hotelMasterId));
					User user = userService.findUserByUserName(memberUserName);

					List<HotelBookingRequest> alreadyBookedList = hotelBookingRequestService
							.findHotelBookingInfoByUserId(Long
									.parseLong(hotelMasterId), user.getId());
					if (alreadyBookedList != null
							&& alreadyBookedList.size() == 0) {
						HotelBookingRequest hotelBookingRequest = new HotelBookingRequest();
						hotelBookingRequest.setHotelMaster(hotelMaster);
						hotelBookingRequest.setUser(user);
						hotelBookingRequestService.saveOrUpdate(hotelBookingRequest);
						addActionMessage("This hotel is booked, our representative will contact you shortly");
					} else {
						addActionError("This hotel is already booked by you. Our representative will contact you shortly");
					}
				} else {
					addActionError("There was some problem while making the booking request, Please try again.");
				}
			}
			if (hotelMasterId != null && !"".equals(hotelMasterId)) {
				hotelMaster = hotelMasterService.findById(Long
						.parseLong(hotelMasterId));
				if (hotelMaster != null) {
					Long masterId = Long.parseLong(hotelMasterId);
					String imageSavePath = "images//HotelImages//"
							+ String.valueOf(hotelMaster.getId());
					setHotelName(hotelMaster.getHotelName());
					setHotelDescription(hotelMaster.getHotelDescription());
					setHotelType(hotelMaster.getHotelType());
					setHotelMainImage(imageSavePath + "//"
							+ hotelMaster.getMainImage());
					setHotelAddress("");
					HotelAddress address = hotelAddressService
							.findHotelAddressByMasterId(masterId);
					if (address != null) {
						setHotelAddress(address.getAddressLine1() + ","
								+ address.getCity() + ", "
								+ address.getPostalCode() + ", "
								+ address.getState() + ", "
								+ address.getCountry());
					}
					List<HotelFacility> facilityList = hotelFacilityService
							.findHotelFacilitiesByHotelMasterId(masterId);
					setHotelFaclityList(facilityList);
					List<HotelPolicy> policyList = hotelPolicyService
							.findHotelPoliciesByHotelMasterId(masterId);
					setHotelPolicyList(policyList);
					List<HotelImages> hotelImages = hotelImagesService
							.findHotelImagesByHotelMasterId(masterId);
					List<HotelImages> tempList = new ArrayList<HotelImages>();
					for (HotelImages image : hotelImages) {
						HotelImages img = new HotelImages();
						img.setId(image.getId());
						img.setImageDescription(image.getImageDescription());
						img.setImageFile(imageSavePath + "//"
								+ image.getImageFile());
						tempList.add(img);
					}
					setHotelImages(tempList);
					session.removeAttribute("memberusername");
					session.removeAttribute("hotelIdForBooking");
					return SUCCESS;
				}
			}

		} catch (Exception e) {

		}
		return ERROR;
	}

	public String bookHotelsInfo() {
		HttpSession session = getHttpServletRequest().getSession();
		session.setAttribute("hotelIdForBooking", hotelMasterId);
		return "USERLOGIN";
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

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelMainImage() {
		return hotelMainImage;
	}

	public void setHotelMainImage(String hotelMainImage) {
		this.hotelMainImage = hotelMainImage;
	}

	public List<HotelImages> getHotelImages() {
		return hotelImages;
	}

	public void setHotelImages(List<HotelImages> hotelImages) {
		this.hotelImages = hotelImages;
	}

	public List<HotelPolicy> getHotelPolicyList() {
		return hotelPolicyList;
	}

	public void setHotelPolicyList(List<HotelPolicy> hotelPolicyList) {
		this.hotelPolicyList = hotelPolicyList;
	}

	public List<HotelFacility> getHotelFaclityList() {
		return hotelFaclityList;
	}

	public void setHotelFaclityList(List<HotelFacility> hotelFaclityList) {
		this.hotelFaclityList = hotelFaclityList;
	}

	public void setHotelMasterService(IHotelMasterService hotelMasterService) {
		this.hotelMasterService = hotelMasterService;
	}

	public void setHotelImagesService(IHotelImagesService hotelImagesService) {
		this.hotelImagesService = hotelImagesService;
	}

	public void setHotelFacilityService(
			IHotelFacilityService hotelFacilityService) {
		this.hotelFacilityService = hotelFacilityService;
	}

	public void setHotelPolicyService(IHotelPolicyService hotelPolicyService) {
		this.hotelPolicyService = hotelPolicyService;
	}

	public void setHotelAddressService(IHotelAddressService hotelAddressService) {
		this.hotelAddressService = hotelAddressService;
	}

	public void setHotelBookingRequestService(
			IHotelBookingRequestService hotelBookingRequestService) {
		this.hotelBookingRequestService = hotelBookingRequestService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
