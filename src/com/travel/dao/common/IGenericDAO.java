package com.travel.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 * A generic data access object (DAO) interface, providing methods for all basic
 * operations.
 * 
 * @author nishas
 * 
 * @param <T>
 * @param <ID>
 */
public interface IGenericDAO<T, ID extends Serializable> {

	public T findById(ID id) throws Exception;

	public T saveOrUpdate(T entity) throws Exception;

	public List<T> findAll() throws Exception;

	public void delete(ID id) throws Exception;

	public void saveOrUpdate(List<T> entities) throws Exception;

}
