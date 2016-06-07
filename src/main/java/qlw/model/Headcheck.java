package qlw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "headcheck")
public class Headcheck {
	private int hcid;
	private String hcurl;
	private String hcfromtype;
	private String hcfromid;
	private String hcstate;

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	public int getHcid() {
		return hcid;
	}

	public void setHcid(int hcid) {
		this.hcid = hcid;
	}

	public String getHcurl() {
		return hcurl;
	}

	public void setHcurl(String hcurl) {
		this.hcurl = hcurl;
	}

	public String getHcfromtype() {
		return hcfromtype;
	}

	public void setHcfromtype(String hcfromtype) {
		this.hcfromtype = hcfromtype;
	}

	public String getHcfromid() {
		return hcfromid;
	}

	public void setHcfromid(String hcfromid) {
		this.hcfromid = hcfromid;
	}

	public String getHcstate() {
		return hcstate;
	}

	public void setHcstate(String hcstate) {
		this.hcstate = hcstate;
	}

}
