package qlw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qlw.dao.ShopcartinfoDao;
import qlw.interfaces.ServiceInterface;
import qlw.model.Goods;
import qlw.model.Page;
import qlw.model.Shopcartinfo;

@Service
@Transactional
public class ShopCartService implements ServiceInterface {
	@Autowired
	private ShopcartinfoDao shopcartinfoDao;
	@Autowired
	private GoodsListForUserService goodsListForUserService;

	// 减一
	public void subToCart(String gid, String cid) {
		Goods goods = goodsListForUserService.getCurrentGoods(gid);
		List<Shopcartinfo> shopcartinfolist = shopcartinfoDao.findByHQL("from Shopcartinfo where gid = " + gid, null);
		Shopcartinfo shopcartinfo = shopcartinfolist.get(0);
		shopcartinfo.setScimoney(shopcartinfo.getScimoney() - goods.getGprice());
		shopcartinfo.setScinumber(shopcartinfo.getScinumber() - 1);
		shopcartinfoDao.update(shopcartinfo);
	}

	// 单个添加
	public void addToCart(String gid, String cid) {
		Goods goods = goodsListForUserService.getCurrentGoods(gid);
		List<Shopcartinfo> shopcartinfolist = shopcartinfoDao.findByHQL("from Shopcartinfo where gid = " + gid, null);
		// 购物车没有
		if (shopcartinfolist.size() == 0) {
			Shopcartinfo shopcartinfo = new Shopcartinfo();
			shopcartinfo.setCid(cid);
			shopcartinfo.setGid(Integer.parseInt(gid));
			shopcartinfo.setScimoney(goods.getGprice());
			shopcartinfo.setScinumber(1);
			shopcartinfoDao.save(shopcartinfo);
		}
		// 购物车已经有
		else {
			Shopcartinfo shopcartinfo = shopcartinfolist.get(0);
			shopcartinfo.setScimoney(shopcartinfo.getScimoney() + goods.getGprice());
			shopcartinfo.setScinumber(shopcartinfo.getScinumber() + 1);
			shopcartinfoDao.update(shopcartinfo);
		}
	}

	/**
	 * 分页查询 queryForPage_Shopcarts
	 * 
	 * @param currentPage
	 *            当前页号：现在显示的页数
	 * @param pageSize
	 *            每页显示的记录条数
	 * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_Shopcarts(int currentPage, int pageSize, String cid) {
		Page page = new Page();
		String hql = "from Shopcartinfo where cid = '" + cid + "'";
		// 总记录数
		int allRow = shopcartinfoDao.getAllRowCount(hql, null);

		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
		List<Shopcartinfo> list = shopcartinfoDao.findByPageByCid(offset, pageSize, cid);
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}

	public Shopcartinfo getShopcartinfo(String sciid) {

		return shopcartinfoDao.findById(Integer.parseInt(sciid));
	}

	public void shopcartinfoDelete(String sciid) {

		shopcartinfoDao.delete(Integer.parseInt(sciid));
	}
}
