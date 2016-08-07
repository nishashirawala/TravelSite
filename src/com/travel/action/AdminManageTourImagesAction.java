package com.travel.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ValidationAware;
import com.travel.model.TourImages;
import com.travel.model.TourMaster;
import com.travel.service.ITourImagesService;
import com.travel.service.ITourMasterService;

@SuppressWarnings("serial")
public class AdminManageTourImagesAction extends BaseAction implements
		ValidationAware {

	private File mainImage;
	private String mainImageContentType;
	private String mainImageFileName;

	private List<File> thumbnailImage = new ArrayList<File>();
	private List<String> thumbnailImageContentType = new ArrayList<String>();
	private List<String> thumbnailImageFileName = new ArrayList<String>();

	private ITourMasterService tourMasterService;
	private ITourImagesService tourImagesService;

	private Map<String, String> tourMap;
	private String tourMasterId;
	private String selectedTourId;

	public String populatePage() {
		try {
			List<TourMaster> allTours = tourMasterService.findAll();
			tourMap = new HashMap<String, String>();
			for (TourMaster tourMaster : allTours) {
				tourMap.put(String.valueOf(tourMaster.getId()), tourMaster
						.getTourName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String uploadImage() {
		String filePath = getServletContext().getRealPath("/");
		if (selectedTourId != null && !"".equals(selectedTourId)) {
			Long ID = new Long(-1);
			try {
				ID = Long.parseLong(selectedTourId);
			} catch (NumberFormatException nfe) {
				addActionError("Unable to save images");
			}
			try {
				TourMaster tourMaster = tourMasterService.findById(ID);
				if (tourMaster != null) {

					String imageSavePath = filePath + "\\images\\Tours\\"
							+ selectedTourId;

					if (mainImageFileName != null
							&& !("".equals(mainImageFileName))) {
						File fileToCreate = new File(imageSavePath,
								mainImageFileName);
						FileUtils.copyFile(this.mainImage, fileToCreate);

						tourMaster.setMainImage(mainImageFileName);
						tourMasterService.saveOrUpdate(tourMaster);
					}

					if (thumbnailImageFileName != null
							&& thumbnailImageFileName.size() > 0) {
						List<TourImages> allThumbImages = new ArrayList<TourImages>();
						for (int index = 0; index < thumbnailImageFileName
								.size(); index++) {
							TourImages tourImages = new TourImages();
							tourImages.setTourMaster(tourMaster);
							String imageStr = thumbnailImageFileName.get(index);
							File thumnailFileToCreate = new File(imageSavePath,
									imageStr);
							FileUtils.copyFile(thumbnailImage.get(index),
									thumnailFileToCreate);
							tourImages.setImageSource(imageStr);
							allThumbImages.add(tourImages);
						}
						if (allThumbImages.size() > 0) {
							tourImagesService.saveOrUpdate(allThumbImages);
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

	public Map<String, String> getTourMap() {
		return tourMap;
	}

	public void setTourMap(Map<String, String> tourMap) {
		this.tourMap = tourMap;
	}

	public String getTourMasterId() {
		return tourMasterId;
	}

	public void setTourMasterId(String tourMasterId) {
		this.tourMasterId = tourMasterId;
	}

	public String getSelectedTourId() {
		return selectedTourId;
	}

	public void setSelectedTourId(String selectedTourId) {
		this.selectedTourId = selectedTourId;
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

	public void setTourMasterService(ITourMasterService tourMasterService) {
		this.tourMasterService = tourMasterService;
	}

	public void setTourImagesService(ITourImagesService tourImagesService) {
		this.tourImagesService = tourImagesService;
	}

}
