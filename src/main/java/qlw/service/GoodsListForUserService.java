package qlw.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qlw.dao.GoodsDao;
import qlw.interfaces.ServiceInterface;
import qlw.model.Goods;
import qlw.model.Page;

@Service
@Transactional
public class GoodsListForUserService implements ServiceInterface {
	@Autowired
	private GoodsDao goodsDao;

	/**
	 * 分页查询queryForPage_AddressList
	 * 
	 * @param currentPage
	 *            当前页号：现在显示的页数
	 * @param pageSize
	 *            每页显示的记录条数
	 * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_GoodsList(int currentPage, int pageSize, String bid) {
		Page page = new Page();
		String hql = "from Goods where bid = '" + bid + "' and gremove is null";
		// 总记录数
		int allRow = goodsDao.getAllRowCount(hql, null);
		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
		List<Goods> list = goodsDao.findByPageFromBid(offset, pageSize, bid);

		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}

	// getCurrentGoods
	public Goods getCurrentGoods(String gid) {
		return goodsDao.findById(Integer.parseInt(gid));
	}

	// ModifySave
	public void goodsModifySave(Goods goods) {
		goodsDao.save(goods);
	}

	// 下架
	public void goodsDelete(String gid) {
		Goods goods = goodsDao.findById(Integer.parseInt(gid));
		goods.setGremove(new Date());
		goodsDao.update(goods);
	}

	public void goodsAddSave(Goods goods) {
		// 创建时间设为审核通过的时间
		goodsDao.save(goods);
	}
}
