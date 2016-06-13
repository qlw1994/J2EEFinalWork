package qlw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import qlw.model.Headcheck;
import qlw.model.Page;
import qlw.service.AddressListService;

@Controller
@RequestMapping("/AddressList")
public class AddressListController {
	@Autowired
	private AddressListService addressListService;
	
	
	
	//加载所有目录
	@RequestMapping("/")
	public String findAllAddress(HttpServletRequest request, HttpServletResponse response){
		String cid=request.getParameter("customer_id");
		
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = addressListService.queryForPage_AddressList(Integer.valueOf(pageNo), 10,cid);
			request.setAttribute("page", page);
			List<Headcheck> headchecks = page.getList();
			request.setAttribute("headchecks", headchecks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "addressList";
	}
}
