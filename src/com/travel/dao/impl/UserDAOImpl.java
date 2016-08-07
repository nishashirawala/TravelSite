package com.travel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.travel.dao.IUserDAO;
import com.travel.dao.impl.common.AbstractDAOHibernate;
import com.travel.dao.impl.common.NamedQueryConstant;
import com.travel.model.User;

/**
 * Data access object (DAO) for domain model class User.
 * 
 * @see com.einfochips.user.dao.User
 * @author MyEclipse Persistence Tools
 */

public class UserDAOImpl extends AbstractDAOHibernate<User, Long> implements IUserDAO {

	public UserDAOImpl() {
		super(User.class);
	}

	@SuppressWarnings("unchecked")
	public User findUserByUserName(String userName) throws Exception {
		List result = getHibernateTemplate().findByNamedQueryAndNamedParam(NamedQueryConstant.GET_USER_BY_USERNAME, USERNAME, userName);
		if (result.size() > 0)
			return (User) result.get(0);
		else
			return null;
	}

	public User getAuthenticatedUser(String userName, String password) throws Exception {
		Map<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put(USERNAME, userName);
		queryParameters.put(PASSWORD, password);
		User user = (User) findUniqueByParams(NamedQueryConstant.GET_AUTHENTICATED_USER, queryParameters);
		return user;
	}

}