package com.travel.dao.impl.common;

public class NamedQueryConstant {

	public static String GET_USER_BY_USERNAME = "user.getUserByUserName";

	public static String GET_USER_BY_ROLE = "user.getUsersbyRole";

	public static String GET_AUTHENTICATED_USER = "user.getAuthenticatedUser";
	
	public static String GET_HOTEL_ADDRESS_BY_MASTER_ID = "hoteladdress.getAddressByMasterId";
	
	public static String GET_HOTEL_POLICY_BY_MASTER_ID_POLICY_NAME = "hotelpolicy.getPolicyByMasterIdAndPolicyName";
	
	public static String GET_HOTEL_FACILITY_BY_MASTER_ID_FACILITY_NAME = "hotelfacility.getFacilityByMasterIdAndFacilityName";
	
	public static String GET_TOUR_ITINERARY_BY_TOUR_MASTER_ID_AND_DAY = "touritinerary.getItineraryByTourMasterIdAndDay";
	
	public static String GET_ROLE_BY_ROLENAME = "role.getRoleByRoleName";
}