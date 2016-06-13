package qlw.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qlw.dao.CustomerDao;
import qlw.dao.HeadcheckDao;
import qlw.dao.MessagesDao;
import qlw.dao.SystemuserDao;
import qlw.interfaces.ServiceInterface;
import qlw.model.Customer;
import qlw.model.Headcheck;
import qlw.model.Messages;
import qlw.model.Page;
import qlw.model.Systemuser;

@Service
@Transactional
public class ListService implements ServiceInterface {
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private HeadcheckDao headcheckDao;
	@Autowired
	private MessagesDao messagesDao;
	@Autowired
	private SystemuserDao systemuserDao;

	/**
	 * 分页查询queryForPage_Customers
	 * 
	 * @param currentPage
	 *            当前页号：现在显示的页数
	 * @param pageSize
	 *            每页显示的记录条数
	 * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_Customers(int currentPage, int pageSize) {
		Page page = new Page();
		String hql = "from Customer where cremove is null";
		// 总记录数
		int allRow = customerDao.getAllRowCount(hql, null);
		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
		List<Customer> list = customerDao.findByPage(offset, pageSize);

		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}

	/**
	 * 分页查询 queryForPage_HeadPhotos
	 * 
	 * @param currentPage
	 *            当前页号：现在显示的页数
	 * @param pageSize
	 *            每页显示的记录条数
	 * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_HeadPhotos(int currentPage, int pageSize) {
		Page page = new Page();
		String hql = "from Headcheck";
		// 总记录数
		int allRow = headcheckDao.getAllRowCount(hql, null);

		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
		List<Headcheck> list = headcheckDao.findByPageNotCheck(offset, pageSize);
		for (Headcheck headcheck : list) {
			if (headcheck.getHcstate().equals("1")) {
				list.remove(headcheck);
			}
		}
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}

	// 管理员——删除用户
	@SuppressWarnings("unchecked")
	public void customerDelete(String id) {
		customerDao.delete(id);
	}

	// 管理员——修改用户
	public void customerModify(String id, String pwd) {
		Customer cus = customerDao.findById(id);
		cus.setCpwd(pwd);
		customerDao.update(cus);
	}

	// 管理员——图片审核通过
	public void headCheckPass(String hcid, String cid) {
		Headcheck headcheck = headcheckDao.findById(Integer.parseInt(hcid));
		// 发送消息给用户
		Messages messages = new Messages();
		messages.setMcreate(new Date());
		messages.setMcontent("图片审核通过 ID:" + String.valueOf(headcheck.getHcid()));
		messages.setMfrom("系统管理员: " + cid);
		messages.setMstate("0");
		messages.setMto(cid);
		messagesDao.save(messages);
		Customer customer = customerDao.findById(cid);
		customer.setCurl(headcheck.getHcurl());
		// 用户新消息
		int toread = customer.getCtoread() + 1;
		customer.setCtoread(toread);
		customerDao.save(customer);
		// 管理员需审核的头像减一
		Systemuser systemuser = systemuserDao.findById("su");
		int sutoheadcheck = systemuser.getSutoheadcheck() - 1;
		systemuser.setSutoheadcheck(sutoheadcheck);
		// 图片状态改变——已审核通过
		headcheck.setHcstate("1");
		headcheckDao.save(headcheck);
	}

	// 管理员——图片审核不通过
	public void headCheckNotPass(String hcid, String cid, String path) {

		Headcheck headcheck = headcheckDao.findById(Integer.parseInt(hcid));
		// 发送消息给用户
		Messages messages = new Messages();
		messages.setMcreate(new Date());
		messages.setMcontent("图片审核未通过  ID:" + String.valueOf(headcheck.getHcid()));
		messages.setMfrom("系统管理员: " + cid);
		messages.setMstate("0");
		messages.setMto(cid);
		messagesDao.save(messages);
		Customer customer = customerDao.findById(cid);
		// 新消息
		int toread = customer.getCtoread() + 1;
		customer.setCtoread(toread);
		customerDao.save(customer);

		// 管理员需审核的头像减一
		Systemuser systemuser = systemuserDao.findById("su");
		int sutoheadcheck = systemuser.getSutoheadcheck() - 1;
		systemuser.setSutoheadcheck(sutoheadcheck);
		// 文件删除
		String fileName = headcheck.getHcurl().replace("/", "\\");
		String realPath = path + fileName;
		System.out.println("realPath=" + realPath);
		File targetFile = new File(realPath);
		targetFile.delete();
		// 数据库删除
		headcheckDao.delete(Integer.parseInt(hcid));
	}
}
