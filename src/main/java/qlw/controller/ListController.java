package qlw.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import qlw.dao.CustomerDao;
import qlw.model.Customer;
import qlw.model.Headcheck;
import qlw.model.Page;
import qlw.service.ListService;

@Controller
@RequestMapping("/List")
public class ListController {
	@Autowired
	private ListService listService;

	
	
	// 管理员审核头像
	@RequestMapping(value = "/HeadCheck", method = RequestMethod.GET)
	public String findAllHead(HttpServletRequest request, HttpServletResponse response) {
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = listService.queryForPage_HeadPhotos(Integer.valueOf(pageNo), 10);
			request.setAttribute("page", page);
			List<Headcheck> headchecks = page.getList();
			request.setAttribute("headchecks", headchecks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "headlist";
	}

	// 审核头像通过
	@RequestMapping(value = "/HeadPass", method = RequestMethod.GET)
	public String headPass(HttpServletRequest request, HttpServletResponse response) {
		String sutoheadcheck=(String)request.getSession().getAttribute("sutoheadcheck");
		int sutoheadcheckToint=Integer.parseInt(sutoheadcheck)-1;
		request.getSession().setAttribute("sutoheadcheck", String.valueOf(sutoheadcheckToint));
		String hcid = request.getParameter("hcid");
		String cid = request.getParameter("cid");
		listService.headCheckPass(hcid, cid);
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = listService.queryForPage_HeadPhotos(Integer.valueOf(pageNo), 10);
			request.setAttribute("page", page);
			List<Headcheck> headchecks = page.getList();
			request.setAttribute("headchecks", headchecks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "headlist";
	}

	// 审核头像不通过
	@RequestMapping(value = "/HeadNotPass", method = RequestMethod.GET)
	public String headNotPass(HttpServletRequest request, HttpServletResponse response) {
		String sutoheadcheck=(String)request.getSession().getAttribute("sutoheadcheck");
		int sutoheadcheckToint=Integer.parseInt(sutoheadcheck)-1;
		request.getSession().setAttribute("sutoheadcheck", String.valueOf(sutoheadcheckToint));
		String hcid = request.getParameter("hcid");
		String cid = request.getParameter("cid");
		String path = request.getSession().getServletContext().getRealPath("/").replace("\\List\\", "\\");
		System.out.println("HeadNotPass path= "+path);
		listService.headCheckNotPass(hcid, cid,path);
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = listService.queryForPage_HeadPhotos(Integer.valueOf(pageNo), 10);
			request.setAttribute("page", page);
			List<Headcheck> headchecks = page.getList();
			request.setAttribute("headchecks", headchecks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "headlist";
	}

	// 管理员修改用户
	@RequestMapping(value = "/CustomerModify", method = RequestMethod.POST)
	public String customerModify(@RequestParam(value = "id") String cid, @RequestParam(value = "pwd") String cpwd,
			HttpServletRequest request, HttpServletResponse response) {
		String id = cid;
		String pwd = cpwd;
		// System.out.println("id =" + id);
		// System.out.println("pwd =" + pwd);
		listService.customerModify(id, pwd);
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = listService.queryForPage_Customers(Integer.valueOf(pageNo), 10);
			request.setAttribute("page", page);
			List<Customer> customers = page.getList();
			request.setAttribute("customers", customers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customerList";
	}

	// 管理员删除用户
	@RequestMapping(value = "/CustomerDelete")
	public String customerDelete(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (id != null && !id.equals(""))
			listService.customerDelete(id);
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = listService.queryForPage_Customers(Integer.valueOf(pageNo), 10);
			request.setAttribute("page", page);
			List<Customer> customers = page.getList();
			request.setAttribute("customers", customers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customerList";
	}

	// 用户列表分页请求
	@RequestMapping(value = "/Customers", method = RequestMethod.GET)
	public String findAllCustomers(HttpServletRequest request, HttpServletResponse response) {
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = listService.queryForPage_Customers(Integer.valueOf(pageNo), 10);
			request.setAttribute("page", page);
			List<Customer> customers = page.getList();
			request.setAttribute("customers", customers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customerList";
	}
}