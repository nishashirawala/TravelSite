package com.travel.service.impl;

import com.travel.dao.IUserDAO;
import com.travel.model.User;
import com.travel.service.IUserService;
import com.travel.service.common.AbstractService;

public class UserServiceImpl extends AbstractService<User, Long> implements IUserService {

	public void setUserDAO(final IUserDAO userDAO) {
		this.genericDAO = userDAO;
	}

	private IUserDAO getUserDAO() {
		return (IUserDAO) this.genericDAO;
	}

	public User findUserByUserName(String userName) throws Exception {
		return getUserDAO().findUserByUserName(userName);
	}
}
