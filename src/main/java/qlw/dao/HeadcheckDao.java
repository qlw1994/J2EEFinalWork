package qlw.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import qlw.model.Headcheck;

@Repository
public class HeadcheckDao extends BaseDao<Headcheck, Integer> {

	public List<Headcheck> findByPageNotCheck(int start, int count) {
		Criteria criteria = getSession().createCriteria(Headcheck.class).add(Restrictions.eq("hcstate","0"));
		criteria.setFirstResult(start);
		criteria.setMaxResults(count);
		return criteria.list();
		
	}
}
