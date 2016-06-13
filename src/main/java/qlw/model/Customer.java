package qlw.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer")
public class Customer {
	/**
	 * 
	 */
	// 数据库无关属性标注
	// @Transient
	// private static final long serialVersionUID = 1L;
	private String cid;
	private String cname;
	private String cpwd;
	private String cmoney;
	private int ctoread;
	private String curl;
	private Date ccreate;
	private Date cremove;

	@Id
	@GeneratedValue(generator = "assigned")
	@GenericGenerator(name = "assigned", strategy = "assigned")
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public String getCmoney() {
		return cmoney;
	}

	public void setCmoney(String cmoney) {
		this.cmoney = cmoney;
	}

	public int getCtoread() {
		return ctoread;
	}

	public void setCtoread(int ctoread) {
		this.ctoread = ctoread;
	}

	public String getCurl() {
		return curl;
	}

	public void setCurl(String curl) {
		this.curl = curl;
	}

	public Date getCcreate() {
		return ccreate;
	}

	public void setCcreate(Date ccreate) {
		this.ccreate = ccreate;
	}

	public Date getCremove() {
		return cremove;
	}

	public void setCremove(Date cremove) {
		this.cremove = cremove;
	}

}
