package edu.freshen.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.freshen.dao.BaseDao;
@Scope("prototype")
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource(name="sessionFactory")
	public SessionFactory sf;
	
	@Override
	public int insertEntity(T entity) {
		int r=0;
		try {
			sf.getCurrentSession().save(entity);
			r=1;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public int deleteEntity(Class entityClass, Serializable id) {
		int r=1;
		try {
			Session ses=sf.getCurrentSession();
			ses.delete(ses.get(entityClass, id));
		} catch (HibernateException e) {
			e.printStackTrace();
			r=0;
		}
		return r;
	}

	@Override
	public int updateEntity(T entity, Serializable id) {
		int r=1;
		try {
			sf.getCurrentSession().update(entity);
		} catch (HibernateException e) {
			e.printStackTrace();
			r=0;
		}
		return r;
	}

	@Override
	public T getEntity(Class entityClass, Serializable id) {
		return (T) sf.getCurrentSession().get(entityClass, id);
	}

	@Override
	public List<T> queryAll(Class entityClass) {
		String hql="from "+entityClass.getSimpleName();
		Query query = sf.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<T> queryByPage(Class entityClass, int start, int size) {
		String hql="from "+entityClass.getSimpleName() +" c order by c.id DESC";
		Query query = sf.getCurrentSession().createQuery(hql);
		query.setFirstResult(start);
		query.setMaxResults(size);
		return query.list();
	}

	@Override
	public Long countItem(Class entityClass) {
		String hql ="select count(*) from "+entityClass.getSimpleName();
		Query query =sf.getCurrentSession().createQuery(hql);
		return (Long) query.uniqueResult();
	}

}
