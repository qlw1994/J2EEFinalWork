package qlw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import qlw.service.LoginService;

@Controller
@RequestMapping("/Login")
public class LoginController {

	// private ApplicationContext context;
	@Autowired
	private LoginService loginService;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "id") String id, @RequestParam(value = "pwd") String pwd) {
		// context = new ClassPathXmlApplicationContext(
		// "/WEB-INF/configs/spring/applicationContext.xml");
		String res = loginService.loginCheck(id, pwd);
		ModelAndView modelAndView = new ModelAndView();
		if (res.equals("0")) {
			modelAndView.setViewName("loginNotFound");
		} else if (res.equals("1")) {
			modelAndView.setViewName("home");
		} else {
			modelAndView.setViewName("loginError");
		}
		System.out.println("modelAndView name is "+modelAndView.getViewName());
		return modelAndView;
	}
}
