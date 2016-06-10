package qlw.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qlw.dao.CustomerDao;
import qlw.interfaces.ServiceInterface;
import qlw.model.Customer;

@Service
@Transactional
public class RegisterService implements ServiceInterface {
	private static final String FAIL = "FAIL";
	private static final String SUCCESS = "SUCCESS";
	private CustomerDao customerDao;

	@Autowired
	public void setCustomerDao(@Qualifier("customerDao") CustomerDao cus) {
		customerDao = cus;
	}

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

	public void registerSave(String id, String pwd) {
		Customer cus = new Customer();
		cus.setCid(id);
		cus.setCpwd(pwd);
		
		cus.setCcreate(new Date());
		customerDao.save(cus);
	}
}
