package qlw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import qlw.dao.CustomerDao;
import qlw.interfaces.ServiceInterface;
import qlw.model.Customer;

public class RegisterService implements ServiceInterface {
	private static final String FAIL = "FAIL";
	private static final String SUCCESS = "SUCCESS";
	private CustomerDao customerDao;
	@Autowired
	public void setCustomerDao(@Qualifier("customerDao") CustomerDao cus) {
		customerDao = cus;
	}
	
	public String registerCheck(String id){
		String res="";
		Customer customer = customerDao.findById(id);
		if(customer==null){
			res=SUCCESS;
		}else{
			res=FAIL;
		}
		return res;
	}
}
