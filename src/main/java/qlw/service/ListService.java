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
	 * ��ҳ��ѯqueryForPage_Customers
	 * 
	 * @param currentPage
	 *            ��ǰҳ�ţ�������ʾ��ҳ��
	 * @param pageSize
	 *            ÿҳ��ʾ�ļ�¼����
	 * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_Customers(int currentPage, int pageSize) {
		Page page = new Page();
		String hql = "from Customer where cremove is null";
		// �ܼ�¼��
		int allRow = customerDao.getAllRowCount(hql, null);
		// ��ǰҳ��ʼ��¼
		int offset = page.countOffset(currentPage, pageSize);
		// ��ҳ��ѯ�����
		List<Customer> list = customerDao.findByPage(offset, pageSize);

		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}

	/**
	 * ��ҳ��ѯ queryForPage_HeadPhotos
	 * 
	 * @param currentPage
	 *            ��ǰҳ�ţ�������ʾ��ҳ��
	 * @param pageSize
	 *            ÿҳ��ʾ�ļ�¼����
	 * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_HeadPhotos(int currentPage, int pageSize) {
		Page page = new Page();
		String hql = "from Headcheck";
		// �ܼ�¼��
		int allRow = headcheckDao.getAllRowCount(hql, null);

		// ��ǰҳ��ʼ��¼
		int offset = page.countOffset(currentPage, pageSize);
		// ��ҳ��ѯ�����
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

	// ����Ա����ɾ���û�
	@SuppressWarnings("unchecked")
	public void customerDelete(String id) {
		customerDao.delete(id);
	}

	// ����Ա�����޸��û�
	public void customerModify(String id, String pwd) {
		Customer cus = customerDao.findById(id);
		cus.setCpwd(pwd);
		customerDao.update(cus);
	}

	// ����Ա����ͼƬ���ͨ��
	public void headCheckPass(String hcid, String cid) {
		Headcheck headcheck = headcheckDao.findById(Integer.parseInt(hcid));
		// ������Ϣ���û�
		Messages messages = new Messages();
		messages.setMcreate(new Date());
		messages.setMcontent("ͼƬ���ͨ�� ID:" + String.valueOf(headcheck.getHcid()));
		messages.setMfrom("ϵͳ����Ա: " + cid);
		messages.setMstate("0");
		messages.setMto(cid);
		messagesDao.save(messages);
		Customer customer = customerDao.findById(cid);
		customer.setCurl(headcheck.getHcurl());
		// �û�����Ϣ
		int toread = customer.getCtoread() + 1;
		customer.setCtoread(toread);
		customerDao.save(customer);
		// ����Ա����˵�ͷ���һ
		Systemuser systemuser = systemuserDao.findById("su");
		int sutoheadcheck = systemuser.getSutoheadcheck() - 1;
		systemuser.setSutoheadcheck(sutoheadcheck);
		// ͼƬ״̬�ı䡪�������ͨ��
		headcheck.setHcstate("1");
		headcheckDao.save(headcheck);
	}

	// ����Ա����ͼƬ��˲�ͨ��
	public void headCheckNotPass(String hcid, String cid, String path) {

		Headcheck headcheck = headcheckDao.findById(Integer.parseInt(hcid));
		// ������Ϣ���û�
		Messages messages = new Messages();
		messages.setMcreate(new Date());
		messages.setMcontent("ͼƬ���δͨ��  ID:" + String.valueOf(headcheck.getHcid()));
		messages.setMfrom("ϵͳ����Ա: " + cid);
		messages.setMstate("0");
		messages.setMto(cid);
		messagesDao.save(messages);
		Customer customer = customerDao.findById(cid);
		// ����Ϣ
		int toread = customer.getCtoread() + 1;
		customer.setCtoread(toread);
		customerDao.save(customer);

		// ����Ա����˵�ͷ���һ
		Systemuser systemuser = systemuserDao.findById("su");
		int sutoheadcheck = systemuser.getSutoheadcheck() - 1;
		systemuser.setSutoheadcheck(sutoheadcheck);
		// �ļ�ɾ��
		String fileName = headcheck.getHcurl().replace("/", "\\");
		String realPath = path + fileName;
		System.out.println("realPath=" + realPath);
		File targetFile = new File(realPath);
		targetFile.delete();
		// ���ݿ�ɾ��
		headcheckDao.delete(Integer.parseInt(hcid));
	}
}
