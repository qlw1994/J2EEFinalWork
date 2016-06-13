package qlw.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Customer;

@Repository
public class CustomerDao extends BaseDao<Customer, String> {
	@SuppressWarnings("unchecked")
	public List<Customer> findByPageNotRemove(int start, int count) {
		Criteria criteria = getSession().createCriteria(Customer.class).add(Restrictions.isNull("cremove"));
		criteria.setFirstResult(start);
		criteria.setMaxResults(count);
		return criteria.list();
	}
}
