package com.travel.service.impl;

import com.travel.dao.IRoleDAO;
import com.travel.model.Role;
import com.travel.service.IRoleService;
import com.travel.service.common.AbstractService;

public class RoleServiceImpl extends AbstractService<Role, Long> implements IRoleService {

	public void setRoleDAO(final IRoleDAO roleDAO) {
		this.genericDAO = roleDAO;
	}

	private IRoleDAO getRoleDAO() {
		return (IRoleDAO) this.genericDAO;
	}

	public Role findRoleByRoleName(String roleName) throws Exception {
		return getRoleDAO().findRoleByRoleName(roleName);
	}
}
