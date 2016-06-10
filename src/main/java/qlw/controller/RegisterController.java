package qlw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import qlw.service.RegisterService;

@Controller
@RequestMapping("/Register")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	
	public ModelAndView register(@RequestParam(value = "id") String id, @RequestParam(value = "pwd") String pwd){
		String res=registerService.registerCheck(id);
		ModelMap mmap=new ModelMap();
		ModelAndView modelAndView = new ModelAndView();
		if(res.equals("SUCCESS")){
			mmap.addAttribute("register_id",id);
			mmap.addAttribute("register_pwd",pwd);
			modelAndView=new ModelAndView("redirect:/Login/register",mmap);
		}
		//FAIL
		else {
			modelAndView.setViewName("registerError");
		}
		return modelAndView;
	}
}
