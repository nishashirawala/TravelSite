package com.travel.dao.impl;

import com.travel.dao.ITourDestinationDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.model.TourDestination;

/**
 * Data access object (DAO) for domain model class User.
 * 
 * @see com.einfochips.user.dao.User
 * @author MyEclipse Persistence Tools
 */

public class TourDestinationDAOImpl extends AbstractDAOHibernate<TourDestination, Long> implements ITourDestinationDAO {

	public TourDestinationDAOImpl() {
		super(TourDestination.class);
	}


}