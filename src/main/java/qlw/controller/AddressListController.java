package qlw.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import qlw.model.Addresslist;
import qlw.model.Page;
import qlw.service.AddressListService;

@Controller
@RequestMapping("/AddressList")
public class AddressListController {
	@Autowired
	private AddressListService addressListService;

	// 地址编辑跳转
	@RequestMapping("/AddressModify")
	public String addressModify(HttpServletRequest request, HttpServletResponse response) {
		String alid = request.getParameter("alid");
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		Addresslist addresslist = addressListService.getCurrentAddr(alid);
		request.setAttribute("addresslist", addresslist);
		request.setAttribute("pageNo", pageNo);

		return "addressModify";
	}

	// 地址编辑后保存
	@RequestMapping("/AddressModifySave")
	public String addressModifySave(HttpServletRequest request, HttpServletResponse response) {
		String alid = request.getParameter("alid");
		String address = request.getParameter("address");
		String aname = request.getParameter("aname");
		String aphone = request.getParameter("aphone");
		try {
			alid = new String(alid.getBytes("iso8859-1"), "UTF-8");
			address = new String(address.getBytes("iso8859-1"), "UTF-8");
			aname = new String(aname.getBytes("iso8859-1"), "UTF-8");
			aphone = new String(aphone.getBytes("iso8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 解决乱码
		Addresslist addresslist = addressListService.getCurrentAddr(alid);
		String cid = addresslist.getCid();
		addresslist.setAddress(address);
		addresslist.setAname(aname);
		addresslist.setAphone(aphone);
		addressListService.addressModifySave(addresslist);
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = addressListService.queryForPage_AddressList(Integer.valueOf(pageNo), 10, cid);
			request.setAttribute("page", page);
			List<Addresslist> addresslists = page.getList();
			request.setAttribute("addresslists", addresslists);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "addressList";
	}

	// 地址删除
	@RequestMapping("/AddressDelete")
	public String addressDelete(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cid");
		String alid = request.getParameter("alid");
		addressListService.addressDelete(alid);
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = addressListService.queryForPage_AddressList(Integer.valueOf(pageNo), 10, cid);
			request.setAttribute("page", page);
			List<Addresslist> addresslists = page.getList();
			request.setAttribute("addresslists", addresslists);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "addressList";
	}

	// 地址添加跳转
	@RequestMapping("/AddressAdd")
	public String addressAdd(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cid");
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		request.setAttribute("cid", cid);
		request.setAttribute("pageNo", pageNo);
		return "addressListAdd";
	}

	// 地址添加保存
	@RequestMapping("/AddressAddSave")
	public String addressAddSave(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cid");
		String address = request.getParameter("address");
		String aname = request.getParameter("aname");
		String aphone = request.getParameter("aphone");
		try {
			cid = new String(cid.getBytes("iso8859-1"), "UTF-8");
			address = new String(address.getBytes("iso8859-1"), "UTF-8");
			aname = new String(aname.getBytes("iso8859-1"), "UTF-8");
			aphone = new String(aphone.getBytes("iso8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 解决乱码
		Addresslist addresslist = new Addresslist();
		addresslist.setCid(cid);
		addresslist.setAddress(address);
		addresslist.setAname(aname);
		addresslist.setAphone(aphone);
		addressListService.addressAddSave(addresslist);
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = addressListService.queryForPage_AddressList(Integer.valueOf(pageNo), 10, cid);
			request.setAttribute("page", page);
			List<Addresslist> addresslists = page.getList();
			request.setAttribute("addresslists", addresslists);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("cid", cid);
		return "addressList";
	}

	// 加载所有地址
	@RequestMapping()
	public String findAllAddress(HttpServletRequest request, HttpServletResponse response) {
		String cid = (String) request.getSession().getAttribute("customer_id");

		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = addressListService.queryForPage_AddressList(Integer.valueOf(pageNo), 10, cid);
			request.setAttribute("page", page);
			List<Addresslist> addresslists = page.getList();
			request.setAttribute("addresslists", addresslists);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "addressList";
	}
}
