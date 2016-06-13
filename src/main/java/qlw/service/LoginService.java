package qlw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qlw.interfaces.ServiceInterface;
import qlw.dao.CustomerDao;
import qlw.dao.SystemuserDao;
import qlw.model.Customer;
import qlw.model.Systemuser;

@Service
@Transactional
public class LoginService implements ServiceInterface {
	// û���ҵ�ƥ����ʺ�
	private static final String NOTHING = "0";
	// �������
	private static final String FAIL = "2";
	// ͨ����֤
	private static final String TRUE = "1";
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private SystemuserDao systemuserDao;

	/*
	 * ��ͨ�û���¼����֤ ����ֵ 0��û���ʺ� 1��ͨ����֤ 2���������
	 */
	public String loginCheck(String id, String pwd) {
		Customer customer = customerDao.findById(id);
		if (customer == null) {
			return NOTHING;
		} else if (customer.getCpwd().equals(pwd)) {
			return TRUE;
		} else {
			return FAIL;
		}

	}

	// ����Ա��¼��֤ ����ֵ 0��û���ʺ� 1��ͨ����֤ 2���������
	public String systemUserLoginCheck(String id, String pwd) {
		Systemuser systemuser = systemuserDao.findById(id);
		if (systemuser == null) {
			return NOTHING;
		} else if (systemuser.getSupwd().equals(pwd)) {
			return TRUE;
		} else {
			return FAIL;
		}

	}

	// ��õ�ǰ��¼�Ĺ���Ա
	public Systemuser getCurrentSu(String id) {
		return systemuserDao.findById(id);
	}

	// ��õ�ǰ��¼���û�
	public Customer getCurrentCus(String id) {
		return customerDao.findById(id);
	}
}
