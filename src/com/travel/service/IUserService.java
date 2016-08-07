package com.travel.service;

import com.travel.dao.IUserDAO;
import com.travel.model.User;
import com.travel.service.common.IGenericService;

public interface IUserService extends IGenericService<User, Long> {

	void setUserDAO(IUserDAO userDAO);

	User findUserByUserName(String userName) throws Exception;

}
