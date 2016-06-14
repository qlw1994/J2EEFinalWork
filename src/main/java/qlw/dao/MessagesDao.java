package qlw.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Messages;

@Repository
public class MessagesDao extends BaseDao<Messages, Integer> {
	@SuppressWarnings("unchecked")
	public List<Messages> findByPageByMTONotRead(int start, int count, String mto) {
		Criteria criteria = getSession().createCriteria(Messages.class).add(Restrictions.eq("mto", mto))
				.add(Restrictions.eq("mstate", "0")).add(Restrictions.isNull("mremove"));
		criteria.setFirstResult(start);
		criteria.setMaxResults(count);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Messages> findByPageByMTOIsRead(int start, int count, String mto) {
		Criteria criteria = getSession().createCriteria(Messages.class).add(Restrictions.eq("mto", mto))
				.add(Restrictions.eq("mstate", "1")).add(Restrictions.isNull("mremove"));
		criteria.setFirstResult(start);
		criteria.setMaxResults(count);
		return criteria.list();
	}
}
