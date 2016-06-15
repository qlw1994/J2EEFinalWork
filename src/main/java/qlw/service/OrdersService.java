package qlw.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qlw.dao.GoodsDao;
import qlw.dao.OrdersDao;
import qlw.interfaces.ServiceInterface;
import qlw.model.Customer;
import qlw.model.Orders;
import qlw.model.Page;

@Service
@Transactional
public class OrdersService implements ServiceInterface {
	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private GoodsDao goodsDao;
	// 未退款列表
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_OrdersNotRefund(int currentPage, int pageSize, String cid) {
		Page page = new Page();
		String hql = "from orders where oremove is NULL and ostate = '0' and cid = '" + cid + "'";
		// 总记录数
		int allRow = ordersDao.getAllRowCount(hql, null);
		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
		List<Orders> list = ordersDao.findByPageNotRefund(offset, pageSize, cid);

		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}

	// 退款列表
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page queryForPage_OrdersIsRefund(int currentPage, int pageSize, String cid) {
		Page page = new Page();
		String hql = "from orders where oremove is NULL and ostate = '1' and cid = '" + cid + "'";
		// 总记录数
		int allRow = ordersDao.getAllRowCount(hql, null);
		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
		List<Orders> list = ordersDao.findByPageIsRefund(offset, pageSize, cid);

		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);

		return page;
	}

	public Orders getCurrentOder(String oid) {
		return ordersDao.findById(Integer.parseInt(oid));
	}
	
	public void orderRefund(String oid){
//		Orders order=ordersDao.findById(Integer.parseInt(oid));
//		order.setOrefunddate(new Date());
//		order.setOstate("1");
		
	}
}
