package com.travel.service.common;

import java.io.Serializable;
import java.util.List;

import com.travel.dao.common.IGenericDAO;

/**
 * Class to provide generic methods to be used for all dao.
 * 
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractService<T, ID extends Serializable> implements
		IGenericService<T, ID> {

	protected IGenericDAO<T, ID> genericDAO;

	public T findById(ID id) throws Exception {
		return genericDAO.findById(id);
	}

	public List<T> findAll() throws Exception {
		return (List<T>) genericDAO.findAll();
	}

	public T saveOrUpdate(T entity) throws Exception {
		return genericDAO.saveOrUpdate(entity);
	}

	public void delete(ID id) throws Exception {
		genericDAO.delete(id);
	}

	public void saveOrUpdate(List<T> entities) throws Exception {
		genericDAO.saveOrUpdate(entities);
	}

}
