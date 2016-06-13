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

import qlw.model.Systemuser;
import qlw.service.LoginService;

@Controller
@RequestMapping("/Login")
public class LoginController {

	// private ApplicationContext context;
	@Autowired
	private LoginService loginService;

	// 管理员登录入口
	@RequestMapping("/SystemUser")
	public ModelAndView systemUserLogin(@RequestParam(value = "id") String id, @RequestParam(value = "pwd") String pwd,
			HttpServletRequest request) {
		String res = loginService.systemUserLoginCheck(id, pwd);
		ModelAndView modelAndView = new ModelAndView();
		ModelMap mmap = new ModelMap();
		if (res.equals("0")) {
			modelAndView.setViewName("sysloginNotFound");
		} else if (res.equals("1")) {
			Systemuser currentSu = loginService.getCurrentSu(id);
			request.getSession().setAttribute("sysuser_id", id);
			request.getSession().setAttribute("sutoheadcheck", currentSu.getSutoheadcheck());
			request.getSession().setAttribute("sutogoodscheck", currentSu.getSutogoodscheck());
			modelAndView = new ModelAndView("syshome", mmap);
		} else {
			modelAndView.setViewName("sysloginError");
		}
		return modelAndView;
	}

	// 注册成功后登录入口
	@RequestMapping("/RegisterLogin")
	public ModelAndView registerLogin(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		ModelMap mmap = new ModelMap();
		request.getSession().setAttribute("customer_id", request.getParameter("register_id"));
		// mmap.addAttribute("customer_id",
		// request.getParameter("register_id"));
		// mmap.addAttribute("customer_pwd",
		// request.getParameter("register_pwd"));
		modelAndView = new ModelAndView("home", mmap);
		return modelAndView;
	}

	// 登录界面登录路口
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "id") String id, @RequestParam(value = "pwd") String pwd,
			HttpServletRequest request) {
		// context = new ClassPathXmlApplicationContext(
		// "/WEB-INF/configs/spring/applicationContext.xml");
		String res = loginService.loginCheck(id, pwd);
		ModelAndView modelAndView = new ModelAndView();
		ModelMap mmap = new ModelMap();
		if (res.equals("0")) {
			modelAndView.setViewName("loginNotFound");
		} else if (res.equals("1")) {
			request.getSession().setAttribute("customer_id", id);
			request.getSession().setAttribute("customer_pwd", pwd);
			// mmap.addAttribute("customer_id", id);
			// mmap.addAttribute("customer_pwd", pwd);
			modelAndView = new ModelAndView("home", mmap);
		} else {
			modelAndView.setViewName("loginError");
		}
		return modelAndView;
	}

}
