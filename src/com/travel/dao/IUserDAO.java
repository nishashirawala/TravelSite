package com.travel.dao;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.User;

/**
 * Interface for UserDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IUserDAO extends IGenericDAO<User, Long> {
	String USERNAME = "userName";

	String PASSWORD = "password";

	String ROLENAME = "roleName";

	User findUserByUserName(String userName) throws Exception;

	User getAuthenticatedUser(String userName, String password) throws Exception;

	User findById(Long id) throws Exception;
}