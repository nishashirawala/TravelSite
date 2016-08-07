package com.travel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.travel.dao.ITourImagesDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.model.TourImages;

/**
 * Data access object (DAO) for domain model class User.
 * 
 * @see com.einfochips.user.dao.User
 * @author MyEclipse Persistence Tools
 */

public class TourImagesDAOImpl extends AbstractDAOHibernate<TourImages, Long> implements ITourImagesDAO {

	public TourImagesDAOImpl() {
		super(TourImages.class);
	}
	
	public List<TourImages> findImagesByTourMasterId(Long tourId) throws Exception {
		Map<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("tourMasterId", tourId);
		
		return findByCriteria(Restrictions.or(Property
				.forName("tourMaster.id").isNull(), Property.forName(
				"tourMaster.id").eq(tourId)));
	}

}