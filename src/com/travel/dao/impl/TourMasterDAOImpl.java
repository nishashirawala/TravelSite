package com.travel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.travel.dao.ITourMasterDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.model.TourMaster;

/**
 * Data access object (DAO) for domain model class User.
 * 
 * @see com.einfochips.user.dao.User
 * @author MyEclipse Persistence Tools
 */

public class TourMasterDAOImpl extends AbstractDAOHibernate<TourMaster, Long> implements ITourMasterDAO {

	public TourMasterDAOImpl() {
		super(TourMaster.class);
	}
	
	public List<TourMaster> findAllToursByDestinationId(Long destinationId){
		Map<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("tourDestinationId", destinationId);
		
		return findByCriteria(Restrictions.or(Property
				.forName("tourDestination.id").isNull(), Property.forName(
				"tourDestination.id").eq(destinationId)));
	}

}