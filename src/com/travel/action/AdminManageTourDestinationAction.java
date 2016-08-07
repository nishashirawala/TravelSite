package com.travel.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.travel.model.TourDestination;
import com.travel.service.ITourDestinationService;

@SuppressWarnings("serial")
public class AdminManageTourDestinationAction extends BaseAction {

	ITourDestinationService tourDestinationService;

	private String destinationId;
	private String destinationName;
	private String destinationDescription;

	public void getAllTourDestination() {
		try {
			List<TourDestination> tourDestinationList = tourDestinationService
					.findAll();
			JSONArray tourDetailsArray = new JSONArray();
			for (TourDestination tourDestination : tourDestinationList) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("tourDestinationId", tourDestination.getId());
				jsonObject.put("tourDestinationName", tourDestination
						.getDestinationName());
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

	public String addTourDestination() {
		return SUCCESS;
	}

	public String saveTourDestination() {
		try {
			TourDestination tourDestination = null;
			if(destinationId==null || "".equals(destinationId) ) {
				tourDestination = new TourDestination();				
			} else {
				tourDestination = tourDestinationService.findById(Long.parseLong(destinationId));
			}
			
			tourDestination.setDestinationName(destinationName);
			tourDestination.setDestinationDescription(destinationDescription);
			tourDestinationService.saveOrUpdate(tourDestination);
			addActionMessage("Tour Destination Saved Successfully");
		} catch (Exception e) {
			addActionError("Error while saving tour destination");
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String showTourDestination() {
		try {
			if (destinationId != null && !"".equals(destinationId)) {
				TourDestination tourDestination = tourDestinationService
						.findById(Long.parseLong(destinationId));
				if (tourDestination != null) {
					destinationName = tourDestination.getDestinationName();
					destinationDescription = tourDestination.getDestinationDescription();
					destinationId = String.valueOf(tourDestination.getId());
					return SUCCESS;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		addActionError("Some problem while retriving Tour destination");
		return SUCCESS;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getDestinationDescription() {
		return destinationDescription;
	}

	public void setDestinationDescription(String destinationDescription) {
		this.destinationDescription = destinationDescription;
	}

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public void setTourDestinationService(
			ITourDestinationService tourDestinationService) {
		this.tourDestinationService = tourDestinationService;
	}
}
