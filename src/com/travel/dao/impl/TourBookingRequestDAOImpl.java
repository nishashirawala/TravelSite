package com.travel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.travel.dao.ITourBookingRequestDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.model.TourBookingRequest;

public class TourBookingRequestDAOImpl extends
		AbstractDAOHibernate<TourBookingRequest, Long> implements
		ITourBookingRequestDAO {

	public TourBookingRequestDAOImpl() {
		super(TourBookingRequest.class);
	}
	
	public List<TourBookingRequest> findTourBookingInfoByUserId(Long tourId, Long userId) throws Exception {
		Map<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("tourMasterId", tourId);
		queryParameters.put("userId", userId);
		return findByCriteria(Restrictions.or(Property.forName("tourMaster.id").isNull(), Property.forName("tourMaster.id").eq(tourId)),
				Restrictions.or(Property.forName("user.id").isNull(), Property.forName("user.id").eq(userId)));
	}

}