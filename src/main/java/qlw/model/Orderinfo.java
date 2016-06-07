package qlw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orderinfo")
public class Orderinfo {
	private int oiid;
	private int oid;
	private int oinumber;
	private double oimoney;

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	public int getOiid() {
		return oiid;
	}

	public void setOiid(int oiid) {
		this.oiid = oiid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getOinumber() {
		return oinumber;
	}

	public void setOinumber(int oinumber) {
		this.oinumber = oinumber;
	}

	public double getOimoney() {
		return oimoney;
	}

	public void setOimoney(double oimoney) {
		this.oimoney = oimoney;
	}

}
