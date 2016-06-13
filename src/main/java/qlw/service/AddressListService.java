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
	 * ��ҳ��ѯqueryForPage_AddressList
	 * 
	 * @param currentPage
	 *            ��ǰҳ�ţ�������ʾ��ҳ��
	 * @param pageSize
	 *            ÿҳ��ʾ�ļ�¼����
	 * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_AddressList(int currentPage, int pageSize,String cid) {
		Page page = new Page();
		String hql = "from Addresslist where cid = '"+cid+"'";
		// �ܼ�¼��
		int allRow = addresslistDao.getAllRowCount(hql, null);
		// ��ǰҳ��ʼ��¼
		int offset = page.countOffset(currentPage, pageSize);
		// ��ҳ��ѯ�����
		List<Addresslist> list = addresslistDao.findByPageFromCid(offset, pageSize,cid);

		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}
}
