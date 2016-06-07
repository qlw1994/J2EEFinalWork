package qlw.dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAndHibernate {
	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath*:qlw/configs/spring/applicationContext.xml");
	}

	@Test
	public void test() {
		System.out.println(context.getBean("sessionFactory"));
	}

}
