package qlw.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import qlw.model.Goods;

@Repository
public class GoodsDao extends BaseDao<Goods, Integer> {
	@SuppressWarnings("unchecked")
	public List<Goods> findByPageFromBid(int start, int count, String bid) {
		Criteria criteria = getSession().createCriteria(Goods.class).add(Restrictions.eq("bid", bid))
				.add(Restrictions.isNull("gremove"));
		criteria.setFirstResult(start);
		criteria.setMaxResults(count);
		return criteria.list();
	}

}
