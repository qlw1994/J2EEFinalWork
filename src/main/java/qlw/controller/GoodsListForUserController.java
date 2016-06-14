package qlw.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import qlw.model.Goods;
import qlw.model.Page;
import qlw.service.GoodsListForUserService;

@Controller
@RequestMapping("/GoodsList")
public class GoodsListForUserController {
	@Autowired
	private GoodsListForUserService goodsListForUserService;

	// 商品编辑跳转
	@RequestMapping("/GoodsModify")
	public String addressModify(HttpServletRequest request, HttpServletResponse response) {
		String gid = request.getParameter("gid");
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		Goods goods = goodsListForUserService.getCurrentGoods(gid);
		request.setAttribute("goods", goods);
		request.setAttribute("pageNo", pageNo);

		return "goodsModify";
	}

	// 商品编辑后保存
	@RequestMapping("/GoodsModifySave")
	public String goodsModifySave(HttpServletRequest request, HttpServletResponse response) {
		String gid = request.getParameter("gid");
		String gprice = request.getParameter("gprice");
		String gnumber = request.getParameter("gnumber");
		Goods goods = goodsListForUserService.getCurrentGoods(gid);
		String bid = goods.getBid();
		goods.setGprice(Integer.parseInt(gprice));
		goods.setGnumber(Integer.parseInt(gnumber));
		goodsListForUserService.goodsModifySave(goods);
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = goodsListForUserService.queryForPage_GoodsList(Integer.valueOf(pageNo), 10, bid);
			request.setAttribute("page", page);
			List<Goods> goodslist = page.getList();
			request.setAttribute("goodslist", goodslist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "goodsList";
	}

	// 商品删除
	@RequestMapping("/GoodsDelete")
	public String goodsDelete(HttpServletRequest request, HttpServletResponse response) {
		String bid = (String) request.getSession().getAttribute("customer_id");
		String gid = request.getParameter("gid");
		goodsListForUserService.goodsDelete(gid);
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = goodsListForUserService.queryForPage_GoodsList(Integer.valueOf(pageNo), 10, bid);
			request.setAttribute("page", page);
			List<Goods> goodslist = page.getList();
			request.setAttribute("goodslist", goodslist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "goodsList";
	}

	// 商品申请上架跳转
	@RequestMapping("/GoodsAdd")
	public String goodsAdd(HttpServletRequest request, HttpServletResponse response) {
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		request.setAttribute("pageNo", pageNo);
		return "goodsAdd";
	}

	// 商品申请上架提交
	@RequestMapping("/GoodsAddSave")
	public String goodsAddSave(@RequestParam(value = "photo") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		String bid = (String) request.getSession().getAttribute("customer_id");
		String t2id = request.getParameter("t2id");
		String gname = request.getParameter("gname");
		String gtype1 = request.getParameter("gtype1");
		String gnumber = request.getParameter("gnumber");
		String gprice = request.getParameter("gprice");
		if (file != null) {
			String path = request.getSession().getServletContext().getRealPath("resources/upload")
					.replace("\\GoodsList", "");
			System.out.println("Goods_path=" + path);
			String fileName = new Date().getTime() + bid + ".jpg";
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
			String gurl = (request.getContextPath() + "/resources/upload/" + fileName).replace("/ShopSite/", "")
					.replace("GoodsList/", "");
			System.out.println("Goods_gurl=" + gurl);

			Goods goods = new Goods();
			goods.setBid(bid);
			goods.setGname(gname);
			goods.setGnumber(Integer.parseInt(gnumber));
			goods.setGprice(Double.valueOf(gprice));
			goods.setGtype1(Integer.parseInt(gtype1));
			goods.setGurl(gurl);
			goods.setT2id(Integer.parseInt(t2id));
			goodsListForUserService.goodsAddSave(goods);
			try {
				String pageNo = request.getParameter("pageNo");
				if (pageNo == null) {
					pageNo = "1";
				}
				Page page = goodsListForUserService.queryForPage_GoodsList(Integer.valueOf(pageNo), 10, bid);
				request.setAttribute("page", page);
				List<Goods> goodslist = page.getList();
				request.setAttribute("goodslist", goodslist);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "goodsList";
	}

	// 加载我的所有商品
	@RequestMapping()
	public String findAllMyGoods(HttpServletRequest request, HttpServletResponse response) {
		String bid = (String) request.getSession().getAttribute("customer_id");
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = goodsListForUserService.queryForPage_GoodsList(Integer.valueOf(pageNo), 10, bid);
			request.setAttribute("page", page);
			List<Goods> goodslist = page.getList();
			request.setAttribute("goodslist", goodslist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "goodsList";
	}
}
