package qlw.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath*:qlw/configs/spring/applicationContext.xml");
	}

	@Test
	public void test() {
		Date date = (Date) context.getBean("date");
		System.out.println(date);
	}

}
