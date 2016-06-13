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
	// 没有找到匹配的帐号
	private static final String NOTHING = "0";
	// 密码错误
	private static final String FAIL = "2";
	// 通过验证
	private static final String TRUE = "1";
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private SystemuserDao systemuserDao;

	/*
	 * 普通用户登录的验证 返回值 0：没有帐号 1：通过验证 2：密码错误
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

	// 管理员登录验证 返回值 0：没有帐号 1：通过验证 2：密码错误
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

	// 获得当前登录的管理员
	public Systemuser getCurrentSu(String id) {
		return systemuserDao.findById(id);
	}

	// 获得当前登录的用户
	public Customer getCurrentCus(String id) {
		return customerDao.findById(id);
	}
}
