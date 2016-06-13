package qlw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qlw.dao.AddresslistDao;
import qlw.interfaces.ServiceInterface;
import qlw.model.Addresslist;
import qlw.model.Page;

@Service
@Transactional
public class AddressListService implements ServiceInterface {
	@Autowired
	private AddresslistDao addresslistDao;

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
	public Page queryForPage_AddressList(int currentPage, int pageSize, String cid) {
		Page page = new Page();
		String hql = "from Addresslist where cid = '" + cid + "'";
		// 总记录数
		int allRow = addresslistDao.getAllRowCount(hql, null);
		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
		List<Addresslist> list = addresslistDao.findByPageFromCid(offset, pageSize, cid);

		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}

	// 获取将要编辑地址栏
	public Addresslist getCurrentAddr(String alid) {
		return addresslistDao.findById(Integer.parseInt(alid));
	}

	// 保存编辑后的地址
	public void addressModifySave(Addresslist al) {
		addresslistDao.update(al);
	}

	// 删除地址
	public void addressDelete(String id) {
		addresslistDao.delete(Integer.parseInt(id));
	}

	// 添加
	public void addressAddSave(Addresslist addresslist) {
		addresslistDao.save(addresslist);
	}
}
