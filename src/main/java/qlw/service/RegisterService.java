package qlw.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qlw.dao.BusinessDao;
import qlw.dao.CustomerDao;
import qlw.interfaces.ServiceInterface;
import qlw.model.Business;
import qlw.model.Customer;

@Service
@Transactional
public class RegisterService implements ServiceInterface {
	private static final String FAIL = "FAIL";
	private static final String SUCCESS = "SUCCESS";
	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private BusinessDao businessDao;

	// 注册检测用户名是否重复
	public String registerCheck(String id) {
		String res = "";
		Customer customer = customerDao.findById(id);
		if (customer == null) {
			res = SUCCESS;
		} else {
			res = FAIL;
		}
		return res;
	}

	// 注册保存
	public void registerSave(String id, String pwd) {
		Customer cus = new Customer();
		cus.setCid(id);
		cus.setCpwd(pwd);
		cus.setCcreate(new Date());
		customerDao.save(cus);

		Business bus = new Business();
		bus.setBid(id);
		bus.setBpwd(pwd);
		bus.setBcreate(new Date());
		businessDao.save(bus);
	}
}
