package qlw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "goodscheck")
public class Goodscheck {
	private int gcid;
	private String gcname;
	private int gcnumber;
	private double gcprice;
	private String gcurl;
	private String gcfromid;
	private String gcstate;

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	public int getGcid() {
		return gcid;
	}

	public void setGcid(int gcid) {
		this.gcid = gcid;
	}

	public String getGcname() {
		return gcname;
	}

	public void setGcname(String gcname) {
		this.gcname = gcname;
	}

	public int getGcnumber() {
		return gcnumber;
	}

	public void setGcnumber(int gcnumber) {
		this.gcnumber = gcnumber;
	}

	public double getGcprice() {
		return gcprice;
	}

	public void setGcprice(double gcprice) {
		this.gcprice = gcprice;
	}

	public String getGcurl() {
		return gcurl;
	}

	public void setGcurl(String gcurl) {
		this.gcurl = gcurl;
	}

	public String getGcfromid() {
		return gcfromid;
	}

	public void setGcfromid(String gcfromid) {
		this.gcfromid = gcfromid;
	}

	public String getGcstate() {
		return gcstate;
	}

	public void setGcstate(String gcstate) {
		this.gcstate = gcstate;
	}

}
