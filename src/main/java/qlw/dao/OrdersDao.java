package qlw.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Customer;
import qlw.model.Orders;

@Repository
public class OrdersDao extends BaseDao<Orders, Integer> {
	// 为退款的列表
	@SuppressWarnings("unchecked")
	public List<Orders> findByPageNotRefund(int start, int count, String cid) {
		Criteria criteria = getSession().createCriteria(Orders.class).add(Restrictions.eq("cid", cid))
				.add(Restrictions.eq("ostate", "0")).add(Restrictions.isNull("oremove"));
		criteria.setFirstResult(start);
		criteria.setMaxResults(count);
		return criteria.list();
	}

	// 退款的列表
	@SuppressWarnings("unchecked")
	public List<Orders> findByPageIsRefund(int start, int count, String cid) {
		Criteria criteria = getSession().createCriteria(Orders.class).add(Restrictions.eq("cid", cid))
				.add(Restrictions.eq("ostate", "1")).add(Restrictions.isNull("oremove"));
		criteria.setFirstResult(start);
		criteria.setMaxResults(count);
		return criteria.list();
	}
}
