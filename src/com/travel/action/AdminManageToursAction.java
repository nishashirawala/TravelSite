package com.travel.action;

import java.io.IOException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.travel.model.TourDestination;
import com.travel.model.TourItinerary;
import com.travel.model.TourMaster;
import com.travel.service.ITourDestinationService;
import com.travel.service.ITourItineraryService;
import com.travel.service.ITourMasterService;

@SuppressWarnings("serial")
public class AdminManageToursAction extends BaseAction {

	ITourMasterService tourMasterService;
	ITourDestinationService tourDestinationService;
	ITourItineraryService tourItineraryService;

	private String tourName;
	private String tourId;
	private String tourDescription;
	private String tourPrice;
	private String tourDate;
	private String tourDestinationId;
	private Map<String, String> tourDestinationMap;
	private String tourItineraryDay;
	private Map<String, String> tourItineraryDayMap;
	private String tourItineraryTitle;
	private String tourItineraryDescription;

	public void getAllTours() {
		try {
			List<TourMaster> tourMasterList = tourMasterService.findAll();
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

	public String addTourInformation() {
		try {
			List<TourDestination> destinationList = tourDestinationService
					.findAll();
			if (destinationList != null && destinationList.size() > 0) {
				tourDestinationMap = new HashMap<String, String>();
				for (TourDestination tourDestination : destinationList) {
					tourDestinationMap.put(String.valueOf(tourDestination
							.getId()), tourDestination.getDestinationName());
				}
			}
			EnumSet<ItineraryDay> itineraryDaySet = EnumSet
					.allOf(ItineraryDay.class);
			Iterator<ItineraryDay> it = itineraryDaySet.iterator();
			tourItineraryDayMap = new LinkedHashMap<String, String>();
			while (it.hasNext()) {
				ItineraryDay itineraryDay = it.next();
				tourItineraryDayMap.put(itineraryDay.name(), itineraryDay
						.getItineraryDay());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String showTourInformation() {
		try {
			if (tourId != null && !"".equals(tourId)) {
				TourMaster tourMaster = tourMasterService.findById(Long
						.parseLong(tourId));
				if (tourMaster != null) {
					setTourId(String.valueOf(tourMaster.getId()));
					setTourName(tourMaster.getTourName());
					setTourDescription(tourMaster.getTourDescription());
					setTourDate(tourMaster.getTourDates());
					setTourPrice(tourMaster.getTourPrice());
					List<TourItinerary> list = tourItineraryService
							.findByTourMasterId(Long.parseLong(tourId));
					if (list != null && list.size() > 0) {
						TourItinerary tourItinerary = list.get(0);
						setTourItineraryDay(tourItinerary.getItineraryDay());
						setTourItineraryTitle(tourItinerary.getItineraryTitle());
						setTourItineraryDescription(tourItinerary
								.getItineraryDescription());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addTourInformation();
	}

	public void saveTours() {
		JSONObject object = new JSONObject();
		HttpServletResponse httpServletResponse = getHttpServletResponse();
		try {
			TourDestination tourDestination = tourDestinationService
					.findById(Long.parseLong(tourDestinationId));
			TourMaster tourMaster = new TourMaster();
			if (tourId != null && !("").equals(tourId)) {
				tourMaster = tourMasterService.findById(Long
						.parseLong(tourId));
			} 
			if (tourDestination != null) {
				tourMaster.setTourName(tourName);
				tourMaster.setTourDescription(tourDescription);
				tourMaster.setTourPrice(tourPrice);
				tourMaster.setTourDates(tourDate);
				tourMaster.setTourDestination(tourDestination);
				tourMasterService.saveOrUpdate(tourMaster);
				setTourId(String.valueOf(tourMaster.getId()));
				object.put("response", "success");
				object.put("responseMessage",
						"Tour Information Saved Successfully");
				object.put("tourMasterId", tourMaster.getId());
			} else {
				object.put("response", "error");
				object.put("responseMessage",
						"Problem while saving Tour Information.");
			}
			httpServletResponse.setContentType("application/json");
			httpServletResponse.getWriter().write(object.toString());
			httpServletResponse.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void itinerarySaveTours() {
		JSONObject object = new JSONObject();
		HttpServletResponse httpServletResponse = getHttpServletResponse();
		try {
			if (tourId != null && !("").equals(tourId)) {
				TourMaster tourMaster = tourMasterService.findById(Long
						.parseLong(tourId));
				TourItinerary tourItinerary = tourItineraryService
						.findByTourMasterIdAndDay(Long.parseLong(tourId),
								tourItineraryDay);

				if (tourItinerary == null) {
					tourItinerary = new TourItinerary();
				}
				tourItinerary.setTourMaster(tourMaster);
				tourItinerary.setItineraryDay(tourItineraryDay);
				tourItinerary.setItineraryDescription(tourItineraryDescription);
				tourItinerary.setItineraryTitle(tourItineraryTitle);
				tourItineraryService.saveOrUpdate(tourItinerary);

				object.put("response", "success");
				object.put("responseMessage",
						"Tour Itinerary Saved Successfully");
			} else {
				object.put("response", "error");
				object.put("responseMessage",
						"Error While Saving Tour Itinerary");
			}
			httpServletResponse.setContentType("application/json");
			httpServletResponse.getWriter().write(object.toString());
			httpServletResponse.flushBuffer();
		} catch (Exception e) {
			object.put("response", "error");
			object.put("responseMessage", "Error While Saving Tour Itinerary");
			httpServletResponse.setContentType("application/json");
			try {
				httpServletResponse.getWriter().write(object.toString());
				httpServletResponse.flushBuffer();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void getItineraryByDayTourInformation() {
		JSONObject object = new JSONObject();
		HttpServletResponse httpServletResponse = getHttpServletResponse();
		try {
			if (tourItineraryDay != null && tourId != null
					&& !"".equals(tourItineraryDay) && !"".equals(tourId)) {
				TourItinerary tourItinerary = tourItineraryService
						.findByTourMasterIdAndDay(Long.parseLong(tourId),
								tourItineraryDay);
				if (tourItinerary != null) {
					object.put("tourItineraryTitle", tourItinerary
							.getItineraryTitle());
					object.put("tourItineraryDescription", tourItinerary
							.getItineraryDescription());
				} else {
					object.put("tourItineraryTitle", "");
					object.put("tourItineraryDescription", "");
				}
			} else {
				object.put("tourItineraryTitle", "");
				object.put("tourItineraryDescription", "");
			}
			httpServletResponse.setContentType("application/json");
			httpServletResponse.getWriter().write(object.toString());
			httpServletResponse.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
			object.put("tourItineraryTitle", "");
			object.put("tourItineraryDescription", "");
			httpServletResponse.setContentType("application/json");
			try {
				httpServletResponse.getWriter().write(object.toString());
				httpServletResponse.flushBuffer();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public enum ItineraryDay {
		day1("Day 1"), day2("Day 2"), day3("Day 3"), day4("Day 4"), day5(
				"Day 5"), day6("Day 6"), day7("Day 7"), day8("Day 8"), day9(
				"Day 9"), day10("Day 10"), day11("Day 11"), day12("Day 12");
		private String itineraryDay;

		private ItineraryDay(String name) {
			this.itineraryDay = name;
		}

		public String getItineraryDay() {
			return itineraryDay;
		}
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
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

	public String getTourDestinationId() {
		return tourDestinationId;
	}

	public void setTourDestinationId(String tourDestinationId) {
		this.tourDestinationId = tourDestinationId;
	}

	public String getTourId() {
		return tourId;
	}

	public void setTourId(String tourId) {
		this.tourId = tourId;
	}

	public Map<String, String> getTourDestinationMap() {
		return tourDestinationMap;
	}

	public void setTourDestinationMap(Map<String, String> tourDestinationMap) {
		this.tourDestinationMap = tourDestinationMap;
	}

	public String getTourDate() {
		return tourDate;
	}

	public void setTourDate(String tourDate) {
		this.tourDate = tourDate;
	}

	public String getTourItineraryDay() {
		return tourItineraryDay;
	}

	public void setTourItineraryDay(String tourItineraryDay) {
		this.tourItineraryDay = tourItineraryDay;
	}

	public Map<String, String> getTourItineraryDayMap() {
		return tourItineraryDayMap;
	}

	public void setTourItineraryDayMap(Map<String, String> tourItineraryDayMap) {
		this.tourItineraryDayMap = tourItineraryDayMap;
	}

	public String getTourItineraryTitle() {
		return tourItineraryTitle;
	}

	public void setTourItineraryTitle(String tourItineraryTitle) {
		this.tourItineraryTitle = tourItineraryTitle;
	}

	public String getTourItineraryDescription() {
		return tourItineraryDescription;
	}

	public void setTourItineraryDescription(String tourItineraryDescription) {
		this.tourItineraryDescription = tourItineraryDescription;
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

}
