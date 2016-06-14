package qlw.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "shopcartinfo")
public class Shopcartinfo {
	private int sciid;
	private int scid;
	private int scinumber;
	private Double scimoney;

	private Shopcart shopcart;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)

	@JoinColumn(name = "scid", insertable = false, updatable = false) // 外键为scid，与shopcart中的scid关联,去重复映射
	public Shopcart getShopcart() {
		return shopcart;
	}

	public void setShopcart(Shopcart shopcart) {
		this.shopcart = shopcart;
	}

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
