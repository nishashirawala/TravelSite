package com.travel.service;

import com.travel.dao.IRoleDAO;
import com.travel.model.Role;
import com.travel.service.common.IGenericService;

public interface IRoleService extends IGenericService<Role, Long> {

	void setRoleDAO(IRoleDAO roleDAO);

	Role findRoleByRoleName(String roleName) throws Exception;

}
