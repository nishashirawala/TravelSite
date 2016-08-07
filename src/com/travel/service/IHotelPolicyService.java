package com.travel.service;

import java.util.List;

import com.travel.dao.IHotelPolicyDAO;
import com.travel.model.HotelPolicy;
import com.travel.service.common.IGenericService;

public interface IHotelPolicyService extends IGenericService<HotelPolicy, Long> {

	void setHotelPolicyDAO(IHotelPolicyDAO hotelPolicyDAO);

	List<HotelPolicy> findHotelPoliciesByHotelMasterId(Long hotelMasterId)throws Exception;
	HotelPolicy findHotelPolicyByMasterIdAndPolicyName(Long hotelMasterId, String policyName) throws Exception;
}
