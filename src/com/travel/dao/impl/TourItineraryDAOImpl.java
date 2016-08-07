package com.travel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.travel.dao.ITourItineraryDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.dao.impl.common.NamedQueryConstant;
import com.travel.model.TourItinerary;

/**
 * Data access object (DAO) for domain model class User.
 * 
 * @see com.einfochips.user.dao.User
 * @author MyEclipse Persistence Tools
 */

public class TourItineraryDAOImpl extends
		AbstractDAOHibernate<TourItinerary, Long> implements ITourItineraryDAO {

	public TourItineraryDAOImpl() {
		super(TourItinerary.class);
	}

	public List<TourItinerary> findByTourMasterId(Long tourMasterId) throws Exception {
		Map<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("tourMasterId", tourMasterId);
		
		return findByCriteria(Restrictions.or(Property
				.forName("tourMaster.id").isNull(), Property.forName(
				"tourMaster.id").eq(tourMasterId)));
	}

	public TourItinerary findByTourMasterIdAndDay(Long tourMasterId,
			String itineraryDay) throws Exception {
		Map<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("tourMasterId", tourMasterId);
		queryParameters.put("itineraryDay", itineraryDay);
		TourItinerary tourItinerary = (TourItinerary) findUniqueByParams(
				NamedQueryConstant.GET_TOUR_ITINERARY_BY_TOUR_MASTER_ID_AND_DAY,
				queryParameters);
		return tourItinerary;
	}
}