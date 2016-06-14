package qlw.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qlw.dao.CustomerDao;
import qlw.dao.MessagesDao;
import qlw.interfaces.ServiceInterface;
import qlw.model.Customer;
import qlw.model.Messages;
import qlw.model.Page;

@Service
@Transactional
public class MessageListService implements ServiceInterface {

	@Autowired
	private MessagesDao messagesDao;
	@Autowired
	private CustomerDao customerDao;
	/**
	 * ��ҳ��ѯ queryForPage_MessagesNotRead
	 * 
	 * @param currentPage
	 *            ��ǰҳ�ţ�������ʾ��ҳ��
	 * @param pageSize
	 *            ÿҳ��ʾ�ļ�¼����
	 * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_MessagesNotRead(int currentPage, int pageSize, String mto) {
		Page page = new Page();
		String hql = "from Messages where mto = '" + mto + "' and mstate = '0' and mremove is null";
		// �ܼ�¼��
		int allRow = messagesDao.getAllRowCount(hql, null);

		// ��ǰҳ��ʼ��¼
		int offset = page.countOffset(currentPage, pageSize);
		// ��ҳ��ѯ�����
		List<Messages> list = messagesDao.findByPageByMTONotRead(offset, pageSize, mto);
		for (Messages messages : list) {
			
			messages.setMstate("1");
			messagesDao.update(messages);
		}
		Customer customer=customerDao.findById(mto);
		customer.setCtoread(customer.getCtoread()-list.size());
		customerDao.update(customer);
		
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}
	/**
	 * ��ҳ��ѯ queryForPage_MessagesIsRead
	 * 
	 * @param currentPage
	 *            ��ǰҳ�ţ�������ʾ��ҳ��
	 * @param pageSize
	 *            ÿҳ��ʾ�ļ�¼����
	 * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_MessagesIsRead(int currentPage, int pageSize, String mto) {
		Page page = new Page();
		String hql = "from Messages where mto = '" + mto + "' and mstate = '1' and mremove is null";
		// �ܼ�¼��
		int allRow = messagesDao.getAllRowCount(hql, null);

		// ��ǰҳ��ʼ��¼
		int offset = page.countOffset(currentPage, pageSize);
		// ��ҳ��ѯ�����
		List<Messages> list = messagesDao.findByPageByMTOIsRead(offset, pageSize, mto);
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}
	// ɾ����
	public void messageDelete(String mid) {
		Messages messages = messagesDao.findById(Integer.parseInt(mid));
		messages.setMremove(new Date());
		messagesDao.update(messages);
	}
}
