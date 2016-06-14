package qlw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import qlw.model.Goods;
import qlw.service.GoodsListForUserService;
import qlw.service.ShopCartService;

@Controller
@RequestMapping("/Single")
public class SingleContoller {

	@Autowired
	ShopCartService shopCartService;
	@Autowired
	private GoodsListForUserService goodsListForUserService;

	@RequestMapping("/AddToCart")
	@ResponseBody
	public String addToCart(HttpServletRequest request, HttpServletResponse response) {
		String cid = (String) request.getSession().getAttribute("customer_id");
		if (cid == null || cid.equals("")) {
			return "L";
		}
		String gid = request.getParameter("gid");
		Goods goods = goodsListForUserService.getCurrentGoods(gid);
		int gnumber = goods.getGnumber();
		if (gnumber <= 0) {
			return "0";
		} else {
			gnumber--;
			goods.setGnumber(gnumber);
			goodsListForUserService.goodsModifySave(goods);
			shopCartService.addToCart(gid, cid);
			return String.valueOf(gnumber);
		}
	}

	// 商品页面初始化
	@RequestMapping()
	public String single(HttpServletRequest request, HttpServletResponse response) {
		String gid = request.getParameter("gid");
		Goods goods = goodsListForUserService.getCurrentGoods(gid);
		request.setAttribute("goods", goods);
		return "single";
	}
}
