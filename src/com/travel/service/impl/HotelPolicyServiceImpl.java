package com.travel.service.impl;

import java.util.List;

import com.travel.dao.IHotelPolicyDAO;
import com.travel.model.HotelPolicy;
import com.travel.service.IHotelPolicyService;
import com.travel.service.common.AbstractService;

public class HotelPolicyServiceImpl extends
		AbstractService<HotelPolicy, Long> implements IHotelPolicyService {

	public void setHotelPolicyDAO(IHotelPolicyDAO hotelPolicyDAO) {
		this.genericDAO = hotelPolicyDAO;

	}

	private IHotelPolicyDAO getHotelPolicyDAO() {
		return (IHotelPolicyDAO) this.genericDAO;
	}

	public List<HotelPolicy> findHotelPoliciesByHotelMasterId(Long hotelMasterId)
			throws Exception {
		return getHotelPolicyDAO().findHotelPoliciesByHotelMasterId(
				hotelMasterId);
	}
	
	public HotelPolicy findHotelPolicyByMasterIdAndPolicyName(Long hotelMasterId, String policyName) throws Exception{
		return getHotelPolicyDAO().findHotelPolicyByMasterIdAndPolicyName(hotelMasterId, policyName);
	}
}
