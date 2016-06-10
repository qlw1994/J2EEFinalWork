package qlw.listners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {
	public static int count = 0;

	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		String id = arg0.getServletRequest().getParameter("id");
		String pwd = arg0.getServletRequest().getParameter("pwd");
		System.out.println(++count + "id = " + id);
		System.out.println(count + "pwd = " + pwd);

	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {

	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {

	}

}
