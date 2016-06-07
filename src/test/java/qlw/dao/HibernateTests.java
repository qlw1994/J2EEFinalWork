package qlw.dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qlw.model.Customer;

public class HibernateTests {
	@Autowired
	private CustomerDao customerDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Test
	public void test1() {
		System.out.println("customerDao is " + customerDao);
	}

	@Test
	public void test2() {
		Customer cus = customerDao.findById("su");
		System.out.println("cus's id is " + cus.getCid());
	}

}
