package qlw.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders")
public class Orders {
	private int oid;
	private String cid;
	private Double omoney;
	private Date orefunddate;
	private String oaddress;
	private String oname;
	private String ophone;
	private Date ocreate;
	private Date oremove;
	private String ostate;

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}



	public String getOstate() {
		return ostate;
	}

	public void setOstate(String ostate) {
		this.ostate = ostate;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Double getOmoney() {
		return omoney;
	}

	public void setOmoney(Double omoney) {
		this.omoney = omoney;
	}

	public Date getOrefunddate() {
		return orefunddate;
	}

	public void setOrefunddate(Date orefunddate) {
		this.orefunddate = orefunddate;
	}

	public String getOaddress() {
		return oaddress;
	}

	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getOphone() {
		return ophone;
	}

	public void setOphone(String ophone) {
		this.ophone = ophone;
	}

	public Date getOcreate() {
		return ocreate;
	}

	public void setOcreate(Date ocreate) {
		this.ocreate = ocreate;
	}

	public Date getOremove() {
		return oremove;
	}

	public void setOremove(Date oremove) {
		this.oremove = oremove;
	}

}
