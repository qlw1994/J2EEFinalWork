package qlw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qlw.interfaces.ServiceInterface;
import qlw.dao.CustomerDao;
import qlw.model.Customer;

@Service
@Transactional
public class LoginService implements ServiceInterface {
	// û���ҵ�ƥ����ʺ�
	private static final String NOTHING = "0";
	// �������
	private static final String FAIL = "2";
	// ͨ����֤
	private static final String TRUE = "1";

	private CustomerDao customerDao;

	@Autowired
	public void setCustomerDao(@Qualifier("customerDao") CustomerDao cus) {
		customerDao = cus;
	}

	/*
	 * ����ֵ 0��û���ʺ� 1��ͨ����֤ 2���������
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
}
