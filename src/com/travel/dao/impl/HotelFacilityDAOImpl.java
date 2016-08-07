package com.travel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.travel.dao.IHotelFacilityDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.dao.impl.common.NamedQueryConstant;
import com.travel.model.HotelFacility;

/**
 * Data access object (DAO) for domain model class User.
 * 
 * @see com.einfochips.user.dao.User
 * @author MyEclipse Persistence Tools
 */

public class HotelFacilityDAOImpl extends
		AbstractDAOHibernate<HotelFacility, Long> implements IHotelFacilityDAO {

	public HotelFacilityDAOImpl() {
		super(HotelFacility.class);
	}

	public List<HotelFacility> findHotelFacilitiesByHotelMasterId(
			Long hotelMasterId) throws Exception {
		return findByCriteria(Restrictions.or(Property
				.forName("hotelMaster.id").isNull(), Property.forName(
				"hotelMaster.id").eq(hotelMasterId)));
	}

	public HotelFacility findHotelFacilityByMasterIdAndFacilityName(
			Long hotelMasterId, String facilityName) throws Exception {
		Map<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("masterId", hotelMasterId);
		queryParameters.put("facilityName", facilityName);

		return (HotelFacility) findUniqueByParams(
				NamedQueryConstant.GET_HOTEL_FACILITY_BY_MASTER_ID_FACILITY_NAME,
				queryParameters);
	}
}