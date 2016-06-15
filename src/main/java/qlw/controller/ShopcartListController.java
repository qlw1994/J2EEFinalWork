package qlw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import qlw.model.Goods;
import qlw.model.Page;
import qlw.model.Shopcartinfo;
import qlw.service.GoodsListForUserService;
import qlw.service.ShopCartService;

@Controller
@RequestMapping("/ShopcartList")
public class ShopcartListController {

	@Autowired
	ShopCartService shopCartService;
	@Autowired
	GoodsListForUserService goodsListForUserService;

	@RequestMapping("/ShopcartToOrders")
	public String shopcartToOrders(HttpServletRequest request, HttpServletResponse response){
		
		return "singleOrder";
	}
	
	@RequestMapping("/OrdersList")
	public String ordersList(HttpServletRequest request, HttpServletResponse response){
		
		return "ordersList";
	}
	
	//ajax删除
	@RequestMapping("/OrderRefund")
	@ResponseBody
	public String orderRefund(HttpServletRequest request, HttpServletResponse response){
		
		return "Y";
	}
	@RequestMapping("/ShopcartDelete")
	public String shopcartDelete(HttpServletRequest request, HttpServletResponse response) {
		String cid =(String) request.getSession().getAttribute("customer_id");
		String sciid = request.getParameter("sciid");
		shopCartService.shopcartinfoDelete(sciid);
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = shopCartService.queryForPage_Shopcarts(Integer.valueOf(pageNo), 10, cid);
			request.setAttribute("page", page);
			List<Shopcartinfo> shopcartinfos = page.getList();
			request.setAttribute("shopcartinfos", shopcartinfos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ShopcartList";
	}

	@RequestMapping("/Sub")
	@ResponseBody
	public String shopcartSub(HttpServletRequest request, HttpServletResponse response) {
		String cid = (String) request.getSession().getAttribute("customer_id");
		String gid = request.getParameter("gid");
		Goods goods = goodsListForUserService.getCurrentGoods(gid);
		int gnumber = goods.getGnumber();
		if (gnumber > 0) {
			gnumber++;
			goods.setGnumber(gnumber);
			goodsListForUserService.goodsModifySave(goods);
			shopCartService.subToCart(gid, cid);
		}

		return "Y";
	}

	// 加载购物车列表
	@RequestMapping()
	public String shopcartList(HttpServletRequest request, HttpServletResponse response) {
		String cid = (String) request.getSession().getAttribute("customer_id");
		if (cid == null || cid.equals("")) {
			return "login";
		}
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = shopCartService.queryForPage_Shopcarts(Integer.valueOf(pageNo), 10, cid);
			request.setAttribute("page", page);
			List<Shopcartinfo> shopcartinfos = page.getList();
			request.setAttribute("shopcartinfos", shopcartinfos);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "ShopcartList";
	}

}
