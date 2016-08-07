package com.travel.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.travel.model.TourBookingRequest;
import com.travel.model.TourImages;
import com.travel.model.TourItinerary;
import com.travel.model.TourMaster;
import com.travel.model.User;
import com.travel.service.ITourBookingRequestService;
import com.travel.service.ITourDestinationService;
import com.travel.service.ITourImagesService;
import com.travel.service.ITourItineraryService;
import com.travel.service.ITourMasterService;
import com.travel.service.IUserService;

@SuppressWarnings("serial")
public class ToursPageAction extends BaseAction {

	ITourMasterService tourMasterService;
	ITourDestinationService tourDestinationService;
	ITourItineraryService tourItineraryService;
	ITourImagesService tourImagesService;
	ITourBookingRequestService tourBookingRequestService;
	IUserService userService;

	private String tourDestination;
	private String tourDestinationDescription;
	private String tourName;
	private String tourId;
	private String tourDescription;
	private String tourPrice;
	private String tourDate;
	private String tourMainImage;
	private String tourDestinationId;
	private List<TourItinerary> tourItineraryList;
	private List<TourImages> tourImages;
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");

	public void showAllToursInfo() {
		try {
			List<TourMaster> tourMasterList = tourMasterService.findAll();
			tourDestinationId = getHttpServletRequest().getParameter(
					"tourDestinationId");
			if (tourDestinationId != null && !"-1".equals(tourDestinationId)) {
				tourMasterList = tourMasterService
						.findAllToursByDestinationId(Long
								.parseLong(tourDestinationId));
				if (tourMasterList != null && tourMasterList.size() == 0) {
					// TODO
				}
			}

			JSONArray tourDetailsArray = new JSONArray();
			for (TourMaster tourMaster : tourMasterList) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("tourMasterId", tourMaster.getId());
				jsonObject.put("tourName", tourMaster.getTourName());
				jsonObject.put("tourPrice", tourMaster.getTourPrice());
				jsonObject.put("tourDates", tourMaster.getTourDates());
				tourDetailsArray.put(jsonObject);
			}
			HttpServletResponse httpServletResponse = getHttpServletResponse();
			httpServletResponse.setContentType("application/json");
			httpServletResponse.getWriter().write(tourDetailsArray.toString());
			httpServletResponse.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String displayTourDetails() {
		try {
			TourMaster tourMaster = null;
			// This block is used when user tried to book the tour.
			HttpSession session = getHttpServletRequest().getSession();
			if (session.getAttribute("memberusername") != null
					&& session.getAttribute("tourIdForBooking") != null) {
				tourId = (String) session.getAttribute("tourIdForBooking");
				String memberUserName = (String) session
						.getAttribute("memberusername");
				if (tourId != null && !"".equals(tourId)) {
					tourMaster = tourMasterService.findById(Long
							.parseLong(tourId));
					User user = userService.findUserByUserName(memberUserName);

					List<TourBookingRequest> alreadyBookedList = tourBookingRequestService
							.findTourBookingInfoByUserId(
									Long.parseLong(tourId), user.getId());
					if (alreadyBookedList != null
							&& alreadyBookedList.size() == 0) {
						TourBookingRequest bookingRequest = new TourBookingRequest();
						bookingRequest.setTourMaster(tourMaster);
						bookingRequest.setUser(user);
						tourBookingRequestService.saveOrUpdate(bookingRequest);
						addActionMessage("This tour is booked, our representative will contact you shortly");
					} else {
						addActionError("This tour is already booked by you. Our representative will contact you shortly");
					}
				} else {
					addActionError("There was some problem while making the booking request, Please try again.");
				}
			}

			if (tourId != null && !"".equals(tourId)) {
				tourMaster = tourMasterService.findById(Long.parseLong(tourId));
				if (tourMaster != null) {
					String imageSavePath = "images//Tours//"
							+ String.valueOf(tourMaster.getId());
					setTourId(String.valueOf(tourMaster.getId()));
					setTourName(tourMaster.getTourName());
					setTourDescription(tourMaster.getTourDescription());
					Date date = sdf1.parse(tourMaster.getTourDates());
					setTourDate(sdf2.format(date));
					setTourPrice(tourMaster.getTourPrice());
					setTourMainImage(imageSavePath + "//"
							+ tourMaster.getMainImage());
					setTourDestination((tourMaster.getTourDestination()
							.getDestinationName()));
					List<TourItinerary> list = tourItineraryService
							.findByTourMasterId(Long.parseLong(tourId));
					setTourItineraryList(list);
					List<TourImages> tourImageList = tourImagesService
							.findImagesByTourMasterId(Long.parseLong(tourId));
					List<TourImages> tempList = new ArrayList<TourImages>();
					for (TourImages tourImages : tourImageList) {
						TourImages img = new TourImages();
						img.setId(tourImages.getId());
						img.setImageDescription(tourImages
								.getImageDescription());
						img.setImageSource(imageSavePath + "//"
								+ tourImages.getImageSource());
						tempList.add(img);
					}

					setTourImages(tempList);
					session.removeAttribute("memberusername");
					session.removeAttribute("tourIdForBooking");
				}
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String bookToursInfo() {
		HttpSession session = getHttpServletRequest().getSession();
		session.setAttribute("tourIdForBooking", tourId);
		return "USERLOGIN";
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getTourId() {
		return tourId;
	}

	public void setTourId(String tourId) {
		this.tourId = tourId;
	}

	public String getTourDescription() {
		return tourDescription;
	}

	public void setTourDescription(String tourDescription) {
		this.tourDescription = tourDescription;
	}

	public String getTourPrice() {
		return tourPrice;
	}

	public void setTourPrice(String tourPrice) {
		this.tourPrice = tourPrice;
	}

	public String getTourDate() {
		return tourDate;
	}

	public void setTourDate(String tourDate) {
		this.tourDate = tourDate;
	}

	public List<TourItinerary> getTourItineraryList() {
		return tourItineraryList;
	}

	public void setTourItineraryList(List<TourItinerary> tourItineraryList) {
		this.tourItineraryList = tourItineraryList;
	}

	public String getTourDestination() {
		return tourDestination;
	}

	public void setTourDestination(String tourDestination) {
		this.tourDestination = tourDestination;
	}

	public String getTourDestinationDescription() {
		return tourDestinationDescription;
	}

	public void setTourDestinationDescription(String tourDestinationDescription) {
		this.tourDestinationDescription = tourDestinationDescription;
	}

	public String getTourMainImage() {
		return tourMainImage;
	}

	public void setTourMainImage(String tourMainImage) {
		this.tourMainImage = tourMainImage;
	}

	public List<TourImages> getTourImages() {
		return tourImages;
	}

	public void setTourImages(List<TourImages> tourImages) {
		this.tourImages = tourImages;
	}

	public String getTourDestinationId() {
		return tourDestinationId;
	}

	public void setTourDestinationId(String tourDestinationId) {
		this.tourDestinationId = tourDestinationId;
	}

	public void setTourMasterService(ITourMasterService tourMasterService) {
		this.tourMasterService = tourMasterService;
	}

	public void setTourDestinationService(
			ITourDestinationService tourDestinationService) {
		this.tourDestinationService = tourDestinationService;
	}

	public void setTourItineraryService(
			ITourItineraryService tourItineraryService) {
		this.tourItineraryService = tourItineraryService;
	}

	public void setTourImagesService(ITourImagesService tourImagesService) {
		this.tourImagesService = tourImagesService;
	}

	public void setTourBookingRequestService(
			ITourBookingRequestService tourBookingRequestService) {
		this.tourBookingRequestService = tourBookingRequestService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
