package com.travel.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.travel.dao.IHotelAddressDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.dao.impl.common.NamedQueryConstant;
import com.travel.model.HotelAddress;

/**
 * Data access object (DAO) for domain model class User.
 * 
 * @see com.einfochips.user.dao.User
 * @author MyEclipse Persistence Tools
 */

public class HotelAddressDAOImpl extends
		AbstractDAOHibernate<HotelAddress, Long> implements IHotelAddressDAO {

	public HotelAddressDAOImpl() {
		super(HotelAddress.class);
	}

	public HotelAddress findByHotelByMasterId(Long hotelMasterId)
			throws Exception {
		Map<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("masterId", hotelMasterId);
		HotelAddress hotelAddress = (HotelAddress) findUniqueByParams(
				NamedQueryConstant.GET_HOTEL_ADDRESS_BY_MASTER_ID,
				queryParameters);
		return hotelAddress;
	}

}