package com.travel.dao.impl;

import java.util.List;

import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.travel.dao.IHotelImagesDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.model.HotelImages;
import com.travel.model.HotelPolicy;

/**
 * Data access object (DAO) for domain model class User.
 * 
 * @see com.einfochips.user.dao.User
 * @author MyEclipse Persistence Tools
 */

public class HotelImagesDAOImpl extends AbstractDAOHibernate<HotelImages, Long>
		implements IHotelImagesDAO {

	public HotelImagesDAOImpl() {
		super(HotelImages.class);
	}

	public List<HotelImages> findHotelImagesByHotelMasterId(Long hotelMasterId)
			throws Exception {
		return findByCriteria(Restrictions.or(Property
				.forName("hotelMaster.id").isNull(), Property.forName(
				"hotelMaster.id").eq(hotelMasterId)));
	}

}