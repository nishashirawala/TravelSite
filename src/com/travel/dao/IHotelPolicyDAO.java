package com.travel.dao;

import java.util.List;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.HotelPolicy;

/**
 * Interface for Hotel Master.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IHotelPolicyDAO extends IGenericDAO<HotelPolicy, Long> {

	HotelPolicy findById(Long id) throws Exception;

	List<HotelPolicy> findHotelPoliciesByHotelMasterId(Long hotelMasterId)
			throws Exception;
	HotelPolicy findHotelPolicyByMasterIdAndPolicyName(Long hotelMasterId,
			String policyName) throws Exception;
}