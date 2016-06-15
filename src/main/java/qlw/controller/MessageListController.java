package qlw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import qlw.model.Customer;
import qlw.model.Messages;
import qlw.model.Page;
import qlw.service.MessageListService;

@Controller
@RequestMapping("/MessageList")
public class MessageListController {

	@Autowired
	private MessageListService messageListService;

	@RequestMapping("/MessageDelete")
	public String messageDelete(HttpServletRequest request, HttpServletResponse response){
		String mto = (String) request.getSession().getAttribute("customer_id");
		String mid=request.getParameter("mid");

		messageListService.messageDelete(mid);
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = messageListService.queryForPage_MessagesIsRead(Integer.valueOf(pageNo), 10, mto);
			request.setAttribute("page", page);
			List<Messages> messagesList = page.getList();
			request.setAttribute("messagesList", messagesList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "messageListIsRead";
	}
	@RequestMapping("/MessageIsRead")
	public String messageIsRead(HttpServletRequest request, HttpServletResponse response){
		String mto = (String) request.getSession().getAttribute("customer_id");
		
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = messageListService.queryForPage_MessagesIsRead(Integer.valueOf(pageNo), 10, mto);
			request.setAttribute("page", page);
			List<Messages> messagesList = page.getList();
			request.setAttribute("messagesList", messagesList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "messageListIsRead";
	}
	@RequestMapping()
	public String messageList(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("ctoread","0");
		String mto = (String) request.getSession().getAttribute("customer_id");
		if (mto == null || mto.equals("")) {
			return "login";
		}
		try {
			String pageNo = request.getParameter("pageNo");
			if (pageNo == null) {
				pageNo = "1";
			}
			Page page = messageListService.queryForPage_MessagesNotRead(Integer.valueOf(pageNo), 10, mto);
			request.setAttribute("page", page);
			List<Messages> messagesList = page.getList();
			request.setAttribute("messagesList", messagesList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "messageList";
	}
}
