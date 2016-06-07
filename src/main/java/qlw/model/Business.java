package qlw.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "business")
public class Business {
	private String bid;
	private String bname;
	private String bpwd;
	private int btoread;
	private String burl;
	private String baddress;
	private Date bcreate;
	private Date bremove;

	@Id
	@GeneratedValue(generator = "assigned")
	@GenericGenerator(name = "assigned", strategy = "assigned")
	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBpwd() {
		return bpwd;
	}

	public void setBpwd(String bpwd) {
		this.bpwd = bpwd;
	}

	public int getBtoread() {
		return btoread;
	}

	public void setBtoread(int btoread) {
		this.btoread = btoread;
	}

	public String getBurl() {
		return burl;
	}

	public void setBurl(String burl) {
		this.burl = burl;
	}

	public String getBaddress() {
		return baddress;
	}

	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}

	public Date getBcreate() {
		return bcreate;
	}

	public void setBcreate(Date bcreate) {
		this.bcreate = bcreate;
	}

	public Date getBremove() {
		return bremove;
	}

	public void setBremove(Date bremove) {
		this.bremove = bremove;
	}

}
