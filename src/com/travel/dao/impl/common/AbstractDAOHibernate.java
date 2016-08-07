package com.travel.dao.impl.common;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.travel.dao.common.IGenericDAO;
import com.travel.model.common.BaseIdentifiedObject;

/**
 * Class to provide generic methods to be used for all DAO.
 * 
 * @author nishas
 * 
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractDAOHibernate<T, ID extends Serializable> extends
		HibernateDaoSupport implements IGenericDAO<T, ID> {

	protected final Log log = LogFactory.getLog(getClass());

	private Class<? extends T> clazz;

	public AbstractDAOHibernate(Class<? extends T> theClass) {
		this.clazz = theClass;
	}

	public T saveOrUpdate(T entity) {
		if (entity instanceof BaseIdentifiedObject) {
			BaseIdentifiedObject bo = (BaseIdentifiedObject) entity;
			bo.setModificationDate(new Date());
		}
		getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	public void delete(ID id) {
		T t = findById(id, true);
		getHibernateTemplate().delete(t);
	}

	public T findById(ID id) {
		T entity = null;
		entity = (T) getHibernateTemplate().get(this.clazz, id);
		return entity;
	}

	private T findById(ID id, boolean lock) {
		if (id == null) {
			return null;
		}
		T entity = null;
		if (lock) {
			entity = (T) getHibernateTemplate().get(this.clazz, id,
					LockMode.UPGRADE);
		} else {
			entity = (T) getHibernateTemplate().get(this.clazz, id);
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return (List<T>) getHibernateTemplate().loadAll(this.clazz);
	}

	@SuppressWarnings("unchecked")
	protected final List<T> findByCriteria(Criterion... criterion) {
		DetachedCriteria criteria = DetachedCriteria.forClass(this.clazz);
		for (Criterion c : criterion) {
			criteria.add(c);
		}
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public Object findUniqueByParams(String queryName,
			Map<String, Object> queryParameters) throws Exception {
		try {
			Query query = createdNamedQuery(queryName);
			query.setCacheable(true);
			setParametersInQuery(query, queryName, queryParameters);
			if (query != null) {
				return query.uniqueResult();
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private Query createdNamedQuery(String queryName) throws Exception {
		try {
			Query query = getSession().getNamedQuery(queryName);
			query.setCacheable(true);
			return query;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private static void setParametersInQuery(Query query, String queryName,
			Map<String, Object> queryParameters) throws Exception {
		try {
			if (queryParameters != null) {
				Set<String> queryParamKeys = queryParameters.keySet();
				Iterator<String> queryParamIterator = queryParamKeys.iterator();
				while (queryParamIterator.hasNext()) {
					String key = queryParamIterator.next();
					Object value = queryParameters.get(key);
					query.setParameter(key, value);
				}
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void saveOrUpdate(List<T> entities) {
		getHibernateTemplate().saveOrUpdateAll(entities);
	}
}
