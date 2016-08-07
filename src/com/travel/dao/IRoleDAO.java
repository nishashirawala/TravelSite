package com.travel.dao;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.Role;

/**
 * Interface for UserDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IRoleDAO extends IGenericDAO<Role, Long> {

	String ROLENAME = "roleName";

	Role findRoleByRoleName(String roleName) throws Exception;
}