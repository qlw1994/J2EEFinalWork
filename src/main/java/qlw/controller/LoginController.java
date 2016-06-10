package qlw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

	@RequestMapping("/RegisterLogin")
	public ModelAndView registerLogin(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		ModelMap mmap = new ModelMap();
		mmap.addAttribute("customer_id", request.getParameter("register_id"));
		mmap.addAttribute("customer_pwd", request.getParameter("register_pwd"));
		modelAndView = new ModelAndView("home", mmap);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "id") String id, @RequestParam(value = "pwd") String pwd) {
		// context = new ClassPathXmlApplicationContext(
		// "/WEB-INF/configs/spring/applicationContext.xml");
		String res = loginService.loginCheck(id, pwd);
		ModelAndView modelAndView = new ModelAndView();
		ModelMap mmap = new ModelMap();
		if (res.equals("0")) {
			modelAndView.setViewName("loginNotFound");
		} else if (res.equals("1")) {
			mmap.addAttribute("customer_id", id);
			mmap.addAttribute("customer_pwd", pwd);
			modelAndView = new ModelAndView("home", mmap);
		} else {
			modelAndView.setViewName("loginError");
		}
		System.out.println("modelAndView name is " + modelAndView.getViewName());
		return modelAndView;
	}

}
