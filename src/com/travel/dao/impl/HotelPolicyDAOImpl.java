package com.travel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.travel.dao.IHotelPolicyDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.dao.impl.common.NamedQueryConstant;
import com.travel.model.HotelPolicy;

/**
 * Data access object (DAO) for domain model class User.
 * 
 * @see com.einfochips.user.dao.User
 * @author MyEclipse Persistence Tools
 */

public class HotelPolicyDAOImpl extends AbstractDAOHibernate<HotelPolicy, Long>
		implements IHotelPolicyDAO {

	public HotelPolicyDAOImpl() {
		super(HotelPolicy.class);
	}

	public List<HotelPolicy> findHotelPoliciesByHotelMasterId(Long hotelMasterId)
			throws Exception {
		return findByCriteria(Restrictions.or(Property
				.forName("hotelMaster.id").isNull(), Property.forName(
				"hotelMaster.id").eq(hotelMasterId)));
	}

	public HotelPolicy findHotelPolicyByMasterIdAndPolicyName(Long hotelMasterId,
			String policyName) throws Exception {
		Map<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("masterId", hotelMasterId);
		queryParameters.put("policyName", policyName);

		return (HotelPolicy) findUniqueByParams(
				NamedQueryConstant.GET_HOTEL_POLICY_BY_MASTER_ID_POLICY_NAME,
				queryParameters);
	}

}