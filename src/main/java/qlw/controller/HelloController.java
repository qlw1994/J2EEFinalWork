package qlw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/1")
public class HelloController {

	@RequestMapping("/11")
	public String test() {
		return "login";
	}

	@RequestMapping
	public ModelAndView helloMvc() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
}
