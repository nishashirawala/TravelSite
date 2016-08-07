package com.travel.dao.impl;

import com.travel.dao.IHotelMasterDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.model.HotelMaster;

/**
 * Data access object (DAO) for domain model class User.
 * 
 * @see com.einfochips.user.dao.User
 * @author MyEclipse Persistence Tools
 */

public class HotelMasterDAOImpl extends AbstractDAOHibernate<HotelMaster, Long> implements IHotelMasterDAO {

	public HotelMasterDAOImpl() {
		super(HotelMaster.class);
	}


}