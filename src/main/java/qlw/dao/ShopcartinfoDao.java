package qlw.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Customer;
import qlw.model.Shopcartinfo;

@Repository
public class ShopcartinfoDao extends BaseDao<Shopcartinfo, Integer> {

	public List<Shopcartinfo> findByPageByCid(int start, int count,String cid) {
		Criteria criteria = getSession().createCriteria(Shopcartinfo.class).add(Restrictions.eq("cid", cid));
		criteria.setFirstResult(start);
		criteria.setMaxResults(count);
		return criteria.list();
	}

}
