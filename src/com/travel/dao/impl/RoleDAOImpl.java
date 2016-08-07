package com.travel.dao.impl;

import java.util.List;

import com.travel.dao.IRoleDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.dao.impl.common.NamedQueryConstant;
import com.travel.model.Role;

/**
 * Data access object (DAO) for domain model class User.
 * 
 * @see com.einfochips.user.dao.User
 * @author MyEclipse Persistence Tools
 */

public class RoleDAOImpl extends AbstractDAOHibernate<Role, Long> implements IRoleDAO {

	public RoleDAOImpl() {
		super(Role.class);
	}

	@SuppressWarnings("unchecked")
	public Role findRoleByRoleName(String roleName) throws Exception {
		List<Role> result = getHibernateTemplate().findByNamedQueryAndNamedParam(NamedQueryConstant.GET_ROLE_BY_ROLENAME, ROLENAME, roleName);
		
		return (result != null) ? result.get(0) : null;
	}

}