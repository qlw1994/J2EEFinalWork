package qlw.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlw.model.Addresslist;

@Repository("addresslistDao")
public class AddresslistDao extends BaseDao<Addresslist, Integer> {
	@SuppressWarnings("unchecked")
	public List<Addresslist> findByPageFromCid(int start, int count, String cid) {
		Criteria criteria = getSession().createCriteria(Addresslist.class).add(Restrictions.eq("cid", cid));
		criteria.setFirstResult(start);
		criteria.setMaxResults(count);
		return criteria.list();
	}
}
