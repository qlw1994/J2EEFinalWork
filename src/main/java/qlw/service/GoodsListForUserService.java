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
	 * ��ҳ��ѯqueryForPage_AddressList
	 * 
	 * @param currentPage
	 *            ��ǰҳ�ţ�������ʾ��ҳ��
	 * @param pageSize
	 *            ÿҳ��ʾ�ļ�¼����
	 * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_GoodsList(int currentPage, int pageSize, String bid) {
		Page page = new Page();
		String hql = "from Goods where bid = '" + bid + "' and gremove is null";
		// �ܼ�¼��
		int allRow = goodsDao.getAllRowCount(hql, null);
		// ��ǰҳ��ʼ��¼
		int offset = page.countOffset(currentPage, pageSize);
		// ��ҳ��ѯ�����
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

	// �¼�
	public void goodsDelete(String gid) {
		Goods goods = goodsDao.findById(Integer.parseInt(gid));
		goods.setGremove(new Date());
		goodsDao.update(goods);
	}

	public void goodsAddSave(Goods goods) {
		// ����ʱ����Ϊ���ͨ����ʱ��
		goodsDao.save(goods);
	}
}
