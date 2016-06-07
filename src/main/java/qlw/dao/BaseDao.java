package qlw.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.interfaces.BasedaoInterface;

@SuppressWarnings("unchecked")
public class BaseDao<T, PK extends Serializable> implements BasedaoInterface<T, PK> {

	private SessionFactory sessionFactory;

	private Class<T> clazz;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * ͨ�����췽��ָ��DAO�ľ���ʵ����
	 */
	public BaseDao() {
		System.out.println(this);
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		Type type = genericSuperclass.getActualTypeArguments()[0];
		if (type instanceof Class) {
			this.clazz = (Class<T>) type;
		} else if (type instanceof ParameterizedType) {
			this.clazz = (Class<T>) ((ParameterizedType) type).getRawType();
		}
		
	}

	public Session getSession() {

		// ��������ǿ�����(Required)�������ȡ����
		return sessionFactory.getCurrentSession();
	}

	public void save(Class<T> entity) {
		this.getSession().save(entity);
	}

	public void update(Class<T> entity) {
		this.getSession().update(entity);
	}

	public void delete(PK id) {
		this.getSession().delete(this.findById(id));
	}

	@SuppressWarnings("unchecked")
	public T findById(PK pk) {
		return (T) getSession().get(clazz, pk);
	}

	// unchecked ִ����δ����ת��ʱ�ľ��棬���統ʹ�ü���ʱû���÷��� (Generics) ��ָ�����ϱ�������͡�
	@SuppressWarnings("unchecked")
	public List<T> findByHQL(String hql, Object[] params) {
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public int getAllRowCount(String hql, Object[] params) {
		Query query = getSession().createQuery(hql.toString());
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.list().size();

	}

	@SuppressWarnings("unchecked")
	public List<T> findByPage(int start, int count) {
		Criteria criteria = getSession().createCriteria(clazz);
		criteria.setFirstResult(start);
		criteria.setMaxResults(count);
		return criteria.list();
	}
}
