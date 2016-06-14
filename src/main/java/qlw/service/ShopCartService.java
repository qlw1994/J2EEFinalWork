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

	// ��һ
	public void subToCart(String gid, String cid) {
		Goods goods = goodsListForUserService.getCurrentGoods(gid);
		List<Shopcartinfo> shopcartinfolist = shopcartinfoDao.findByHQL("from Shopcartinfo where gid = " + gid, null);
		Shopcartinfo shopcartinfo = shopcartinfolist.get(0);
		shopcartinfo.setScimoney(shopcartinfo.getScimoney() - goods.getGprice());
		shopcartinfo.setScinumber(shopcartinfo.getScinumber() - 1);
		shopcartinfoDao.update(shopcartinfo);
	}

	// �������
	public void addToCart(String gid, String cid) {
		Goods goods = goodsListForUserService.getCurrentGoods(gid);
		List<Shopcartinfo> shopcartinfolist = shopcartinfoDao.findByHQL("from Shopcartinfo where gid = " + gid, null);
		// ���ﳵû��
		if (shopcartinfolist.size() == 0) {
			Shopcartinfo shopcartinfo = new Shopcartinfo();
			shopcartinfo.setCid(cid);
			shopcartinfo.setGid(Integer.parseInt(gid));
			shopcartinfo.setScimoney(goods.getGprice());
			shopcartinfo.setScinumber(1);
			shopcartinfoDao.save(shopcartinfo);
		}
		// ���ﳵ�Ѿ���
		else {
			Shopcartinfo shopcartinfo = shopcartinfolist.get(0);
			shopcartinfo.setScimoney(shopcartinfo.getScimoney() + goods.getGprice());
			shopcartinfo.setScinumber(shopcartinfo.getScinumber() + 1);
			shopcartinfoDao.update(shopcartinfo);
		}
	}

	/**
	 * ��ҳ��ѯ queryForPage_Shopcarts
	 * 
	 * @param currentPage
	 *            ��ǰҳ�ţ�������ʾ��ҳ��
	 * @param pageSize
	 *            ÿҳ��ʾ�ļ�¼����
	 * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_Shopcarts(int currentPage, int pageSize, String cid) {
		Page page = new Page();
		String hql = "from Shopcartinfo where cid = '" + cid + "'";
		// �ܼ�¼��
		int allRow = shopcartinfoDao.getAllRowCount(hql, null);

		// ��ǰҳ��ʼ��¼
		int offset = page.countOffset(currentPage, pageSize);
		// ��ҳ��ѯ�����
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
