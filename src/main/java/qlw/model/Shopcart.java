package qlw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "shopcart")
public class Shopcart {
	private int scid;
	private int gid;
	private String cid;
	private Double scmoney;

	private Set<Shopcartinfo> Shopcartinfos = new HashSet<Shopcartinfo>();

	@OneToMany(mappedBy = "shopcart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<Shopcartinfo> getShopcartinfos() {
		return Shopcartinfos;
	}

	public void setShopcartinfos(Set<Shopcartinfo> shopcartinfos) {
		Shopcartinfos = shopcartinfos;
	}

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	public int getScid() {
		return scid;
	}

	public void setScid(int scid) {
		this.scid = scid;
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

	public Double getScmoney() {
		return scmoney;
	}

	public void setScmoney(Double scmoney) {
		this.scmoney = scmoney;
	}

}
