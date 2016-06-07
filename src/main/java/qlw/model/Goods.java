package qlw.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "goods")
public class Goods {
	private int gid;
	private String bid;
	private int t2id;
	private String gname;
	private int gtype1;
	private int gnumber;
	private double gprice;
	private String gurl;
	private Date gcreate;
	private Date gremove;

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public int getT2id() {
		return t2id;
	}

	public void setT2id(int t2id) {
		this.t2id = t2id;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getGtype1() {
		return gtype1;
	}

	public void setGtype1(int gtype1) {
		this.gtype1 = gtype1;
	}

	public int getGnumber() {
		return gnumber;
	}

	public void setGnumber(int gnumber) {
		this.gnumber = gnumber;
	}

	public double getGprice() {
		return gprice;
	}

	public void setGprice(double gprice) {
		this.gprice = gprice;
	}

	public String getGurl() {
		return gurl;
	}

	public void setGurl(String gurl) {
		this.gurl = gurl;
	}

	public Date getGcreate() {
		return gcreate;
	}

	public void setGcreate(Date gcreate) {
		this.gcreate = gcreate;
	}

	public Date getGremove() {
		return gremove;
	}

	public void setGremove(Date gremove) {
		this.gremove = gremove;
	}

}
