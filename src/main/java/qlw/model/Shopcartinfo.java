package qlw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "shopcartinfo")
public class Shopcartinfo {
	private int sciid;
	private int gid;
	private String cid;
	private int scinumber;
	private Double scimoney;


	

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	public int getSciid() {
		return sciid;
	}

	public void setSciid(int sciid) {
		this.sciid = sciid;
	}


	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public int getScinumber() {
		return scinumber;
	}

	public void setScinumber(int scinumber) {
		this.scinumber = scinumber;
	}

	public Double getScimoney() {
		return scimoney;
	}

	public void setScimoney(Double scimoney) {
		this.scimoney = scimoney;
	}

}
