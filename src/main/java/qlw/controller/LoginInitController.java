package qlw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import qlw.model.Goods;
import qlw.service.GoodsListForUserService;

@Controller
@RequestMapping("/LoginInit")
public class LoginInitController {
	@Autowired
	private GoodsListForUserService goodsListForUserService;
	private Gson gson = new Gson();

	// ajaxº”‘ÿÕº∆¨
	@RequestMapping()
	@ResponseBody
	public String loginInitGoods(HttpServletRequest request, HttpServletResponse response) {
		String jsondata = "";
		List<Goods> goodslsit = goodsListForUserService.loadAllGoods();
		if (goodslsit == null || goodslsit.size() == 0)
			return null;
		else {
			List<Map<String,String>> list=new ArrayList<Map<String,String>>();
			for (Goods goods : goodslsit) {
				Map<String,String> map=new HashMap<String, String>();
				
				map.put("gid", String.valueOf(goods.getGid()));
				map.put("gname",goods.getGname());
				map.put("gurl", goods.getGurl());
				list.add(map);
			}
			   jsondata = gson.toJson(list);
		         
//			 jsondata = gson.toJson(goodslsit);
			 System.out.println("jsondata"+jsondata);
			return jsondata;
		}
	}
}
