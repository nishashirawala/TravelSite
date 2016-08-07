package com.travel.model;

import com.travel.model.common.BaseIdentifiedObject;


public class Role extends BaseIdentifiedObject {

	private String roleName;

	/**
	 * @return the name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param name the name to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}