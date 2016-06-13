package qlw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qlw.dao.CustomerDao;
import qlw.dao.HeadcheckDao;
import qlw.dao.SystemuserDao;
import qlw.interfaces.ServiceInterface;
import qlw.model.Customer;
import qlw.model.Headcheck;
import qlw.model.Systemuser;

@Service
@Transactional
public class PersonalCenterService implements ServiceInterface {
	@Autowired
	private HeadcheckDao headcheckDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private SystemuserDao systemuserDao;

	// 个人中心——名字更新
	public void personalNameSave(String id, String name) {
		Customer cus = customerDao.findById(id);
		cus.setCname(name);
		customerDao.update(cus);
	}

	// 个人中心——图像上传放入审核中心
	public void personalPhotoSave(String id, String url) {
		Headcheck hdc = new Headcheck();
		hdc.setHcfromid(id);
		hdc.setHcfromtype("cus");
		hdc.setHcstate("0");
		hdc.setHcurl(url);
		headcheckDao.save(hdc);
		// 管理员——需审核的头像加1
		Systemuser systemuser = systemuserDao.findById("su");
		int sutoheadcheck = systemuser.getSutoheadcheck() + 1;
		systemuser.setSutoheadcheck(sutoheadcheck);
		systemuserDao.save(systemuser);
	}

}
