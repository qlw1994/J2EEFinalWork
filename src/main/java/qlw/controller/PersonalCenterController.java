package qlw.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import qlw.service.PersonalCenterService;

@Controller
@RequestMapping("/PersonalCenterSave")
public class PersonalCenterController {
	@Autowired
	private PersonalCenterService personalCenterService;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView personalCenterSave(@RequestParam(value = "id") String id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "photo", required = false) MultipartFile file, HttpServletRequest request) {
		ModelMap mmap = new ModelMap();
		System.out.println("Begin PersonalCenterSave " + name);
		ModelAndView modelAndView = new ModelAndView();
		mmap.addAttribute("customer_id", id);
		if (name != null) {
			name = name.trim();
			if (!name.equals("")) {
				personalCenterService.personalNameSave(id, name);
			}
		}
		if (file != null) {
			String path = request.getSession().getServletContext().getRealPath("resources/upload");
			System.out.println("path="+path);
			String fileName = new Date().getTime() + id + ".jpg";
			System.out.println(fileName);
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			try {
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String url = (request.getContextPath() + "/resources/upload/" + fileName).replace("/ShopSite/", "");
			System.out.println("url="+url);
			personalCenterService.personalPhotoSave(id, url);
			// mmap.addAttribute("photoURL",url);
		}
		modelAndView = new ModelAndView("home", mmap);
		System.out.println("End PersonalCenterSave " + name);
		return modelAndView;
	}
}
