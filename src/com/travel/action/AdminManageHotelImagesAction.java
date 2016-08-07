package com.travel.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import com.opensymphony.xwork2.ValidationAware;
import com.travel.model.HotelAddress;
import com.travel.model.HotelImages;
import com.travel.model.HotelMaster;
import com.travel.service.IHotelAddressService;
import com.travel.service.IHotelImagesService;
import com.travel.service.IHotelMasterService;

@SuppressWarnings("serial")
public class AdminManageHotelImagesAction extends BaseAction implements
		ValidationAware {

	private File mainImage;
	private String mainImageContentType;
	private String mainImageFileName;

	private List<File> thumbnailImage = new ArrayList<File>();
	private List<String> thumbnailImageContentType = new ArrayList<String>();
	private List<String> thumbnailImageFileName = new ArrayList<String>();

	private IHotelMasterService hotelMasterService;
	private IHotelAddressService hotelAddressService;
	private IHotelImagesService hotelImagesService;
	private Map<String, String> hotelMap;
	private String hotelMasterId;
	private String selectedMasterId;

	public String populatePage() {
		try {
			List<HotelMaster> hotelList = hotelMasterService.findAll();
			hotelMap = new HashMap<String, String>();
			for (HotelMaster hotelMaster : hotelList) {
				hotelMap.put(String.valueOf(hotelMaster.getId()), hotelMaster
						.getHotelName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void getAddressOfHotel() {
		JSONObject object = new JSONObject();
		HttpServletResponse httpServletResponse = getHttpServletResponse();
		String hotelAddress = "Not Available";
		try {
			if (hotelMasterId != null && !("".equals(hotelMasterId))) {
				Long id = new Long("-1");
				try {
					id = Long.parseLong(hotelMasterId);
				} catch (NumberFormatException nfe) {

				}
				HotelAddress address = hotelAddressService
						.findHotelAddressByMasterId(id);

				if (address != null) {
					hotelAddress = address.getAddressLine1() + " "
							+ address.getCity() + " " + address.getState()
							+ " " + address.getPostalCode() + " "
							+ address.getCountry();
				}
				object.put("hotelAddress", hotelAddress);
				httpServletResponse.setContentType("application/json");
				httpServletResponse.getWriter().write(object.toString());
				httpServletResponse.flushBuffer();
			}
		} catch (Exception e) {
			e.printStackTrace();
			object.put("hotelAddress", hotelAddress);
			httpServletResponse.setContentType("application/json");
			try {
				httpServletResponse.getWriter().write(object.toString());
				httpServletResponse.flushBuffer();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public String uploadImage() {
		String filePath = getServletContext().getRealPath("/");
		if (selectedMasterId != null && !"".equals(selectedMasterId)) {
			Long ID = new Long(-1);
			try {
				ID = Long.parseLong(selectedMasterId);
			} catch (NumberFormatException nfe) {
				addActionError("Unable to save images");
			}
			try {
				HotelMaster hotelMaster = hotelMasterService.findById(ID);
				if (hotelMaster != null) {

					String imageSavePath = filePath + "\\images\\HotelImages\\"
							+ selectedMasterId;
					if (mainImageFileName != null
							&& !("".equals(mainImageFileName))) {
						File fileToCreate = new File(imageSavePath,
								mainImageFileName);
						FileUtils.copyFile(this.mainImage, fileToCreate);
						hotelMaster.setMainImage(mainImageFileName);
						hotelMasterService.saveOrUpdate(hotelMaster);
					}
					if (thumbnailImageFileName != null
							&& thumbnailImageFileName.size() > 0) {
						List<HotelImages> allThumbImages = new ArrayList<HotelImages>();
						for (int index = 0; index < thumbnailImageFileName
								.size(); index++) {
							HotelImages hotelImages = new HotelImages();
							hotelImages.setHotelMaster(hotelMaster);
							String imageStr = thumbnailImageFileName.get(index);
							File thumnailFileToCreate = new File(imageSavePath,
									imageStr);
							FileUtils.copyFile(thumbnailImage.get(index),
									thumnailFileToCreate);
							hotelImages.setImageFile(imageStr);
							allThumbImages.add(hotelImages);
						}
						if (allThumbImages.size() > 0) {
							hotelImagesService.saveOrUpdate(allThumbImages);
						}
					}
					addActionMessage("Images Saved Successfully");
				}

			} catch (Exception e) {
				e.printStackTrace();
				addActionError("Error while saving images. Please try again.");
			}
		}

		return populatePage();
	}

	@Override
	public void validate() {
		super.validate();
		System.out.println(thumbnailImage.size());
		System.out.println(thumbnailImageFileName.size());
	}

	public File getMainImage() {
		return mainImage;
	}

	
	public void setMainImage(File mainImage) {
		this.mainImage = mainImage;
	}

	
	public String getMainImageContentType() {
		return mainImageContentType;
	}

	public void setMainImageContentType(String mainImageContentType) {
		this.mainImageContentType = mainImageContentType;
	}

	public String getMainImageFileName() {
		return mainImageFileName;
	}

	public void setMainImageFileName(String mainImageFileName) {
		this.mainImageFileName = mainImageFileName;
	}

	public Map<String, String> getHotelMap() {
		return hotelMap;
	}

	public void setHotelMap(Map<String, String> hotelMap) {
		this.hotelMap = hotelMap;
	}

	public String getHotelMasterId() {
		return hotelMasterId;
	}

	public void setHotelMasterId(String hotelMasterId) {
		this.hotelMasterId = hotelMasterId;
	}

	public String getSelectedMasterId() {
		return selectedMasterId;
	}

	public void setSelectedMasterId(String selectedMasterId) {
		this.selectedMasterId = selectedMasterId;
	}

	public List<File> getThumbnailImage() {
		return thumbnailImage;
	}

	public void setThumbnailImage(List<File> thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	public List<String> getThumbnailImageContentType() {
		return thumbnailImageContentType;
	}

	public void setThumbnailImageContentType(
			List<String> thumbnailImageContentType) {
		this.thumbnailImageContentType = thumbnailImageContentType;
	}

	public List<String> getThumbnailImageFileName() {
		return thumbnailImageFileName;
	}

	public void setThumbnailImageFileName(List<String> thumbnailImageFileName) {
		this.thumbnailImageFileName = thumbnailImageFileName;
	}

	public void setHotelMasterService(IHotelMasterService hotelMasterService) {
		this.hotelMasterService = hotelMasterService;
	}

	public void setHotelAddressService(IHotelAddressService hotelAddressService) {
		this.hotelAddressService = hotelAddressService;
	}

	public void setHotelImagesService(IHotelImagesService hotelImagesService) {
		this.hotelImagesService = hotelImagesService;
	}

}
