package qlw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import qlw.service.RegisterService;

@Controller
@RequestMapping("/Register")
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	@ResponseBody
	@RequestMapping(value = "/RegisterAjaxCheck", method = RequestMethod.GET)
	public String registerAjaxCheck(@RequestParam(value = "id") String id) {
		String res = "";
		
		res = registerService.registerCheck(id);
		// SUCCESS or FAIL
		System.out.println("/RegisterAjaxCheck");
		if (res.equals("SUCCESS")) {
			res = "可以注册";
		} else {
			res = "用户名已存在";
		}
		return res;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView register(@RequestParam(value = "id") String id, @RequestParam(value = "pwd") String pwd) {
		String res = registerService.registerCheck(id);
		ModelMap mmap = new ModelMap();
		ModelAndView modelAndView = new ModelAndView();
		if (res.equals("SUCCESS")) {
			mmap.addAttribute("register_id", id);
			mmap.addAttribute("register_pwd", pwd);
			registerService.registerSave(id, pwd);
			modelAndView = new ModelAndView("redirect:/Login/RegisterLogin", mmap);
		}
		// FAIL
		else {
			modelAndView.setViewName("registerError");
		}
		return modelAndView;
	}

}
