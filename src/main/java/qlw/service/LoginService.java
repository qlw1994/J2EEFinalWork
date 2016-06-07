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
	// 没有找到匹配的帐号
	private static final String NOTHING = "0";
	// 密码错误
	private static final String FAIL = "2";
	// 通过验证
	private static final String TRUE = "1";

	private CustomerDao customerDao;

	@Autowired
	public void setCustomerDao(@Qualifier("customerDao") CustomerDao cus) {
		customerDao = cus;
	}

	/*
	 * 返回值 0：没有帐号 1：通过验证 2：密码错误
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
