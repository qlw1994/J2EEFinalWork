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
	 * 分页查询 queryForPage_MessagesNotRead
	 * 
	 * @param currentPage
	 *            当前页号：现在显示的页数
	 * @param pageSize
	 *            每页显示的记录条数
	 * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_MessagesNotRead(int currentPage, int pageSize, String mto) {
		Page page = new Page();
		String hql = "from Messages where mto = '" + mto + "' and mstate = '0' and mremove is null";
		// 总记录数
		int allRow = messagesDao.getAllRowCount(hql, null);

		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
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
	 * 分页查询 queryForPage_MessagesIsRead
	 * 
	 * @param currentPage
	 *            当前页号：现在显示的页数
	 * @param pageSize
	 *            每页显示的记录条数
	 * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_MessagesIsRead(int currentPage, int pageSize, String mto) {
		Page page = new Page();
		String hql = "from Messages where mto = '" + mto + "' and mstate = '1' and mremove is null";
		// 总记录数
		int allRow = messagesDao.getAllRowCount(hql, null);

		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
		List<Messages> list = messagesDao.findByPageByMTOIsRead(offset, pageSize, mto);
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}
	// 删除软
	public void messageDelete(String mid) {
		Messages messages = messagesDao.findById(Integer.parseInt(mid));
		messages.setMremove(new Date());
		messagesDao.update(messages);
	}
}
