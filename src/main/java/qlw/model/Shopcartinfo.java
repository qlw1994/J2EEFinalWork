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
	private int scid;
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

	public int getScid() {
		return scid;
	}

	public void setScid(int scid) {
		this.scid = scid;
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
