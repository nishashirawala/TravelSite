package com.travel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.travel.dao.IHotelBookingRequestDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.model.HotelBookingRequest;

public class HotelBookingRequestDAOImpl extends
		AbstractDAOHibernate<HotelBookingRequest, Long> implements
		IHotelBookingRequestDAO {

	public HotelBookingRequestDAOImpl() {
		super(HotelBookingRequest.class);
	}
	
	public List<HotelBookingRequest> findHotelBookingInfoByUserId(Long hotelId, Long userId) throws Exception {
		Map<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("hotelMasterId", hotelId);
		queryParameters.put("userId", userId);
		return findByCriteria(Restrictions.or(Property.forName("hotelMaster.id").isNull(), Property.forName("hotelMaster.id").eq(hotelId)),
				Restrictions.or(Property.forName("user.id").isNull(), Property.forName("user.id").eq(userId)));
	}

}