package com.travel.service.common;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<T, ID extends Serializable> {

	T findById(ID id) throws Exception;

	T saveOrUpdate(T entity) throws Exception;

	List<T> findAll() throws Exception;

	public void delete(ID id) throws Exception;

	public void saveOrUpdate(List<T> entities) throws Exception;

}
