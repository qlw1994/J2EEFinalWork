package qlw.model;

import java.util.Date;
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
@Table(name = "type2")
public class Type2 {
	private int t2id;
	private int t1id;
	private String t2name;
	private Date t2create;
	private Date t2remove;
	private Set<Goods> goodslist=new HashSet<Goods>();
	@OneToMany(mappedBy = "type2", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<Goods> getGoodslist() {
		return goodslist;
	}

	public void setGoodslist(Set<Goods> goodslist) {
		this.goodslist = goodslist;
	}

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	public int getT2id() {
		return t2id;
	}

	public void setT2id(int t2id) {
		this.t2id = t2id;
	}

	public int getT1id() {
		return t1id;
	}

	public void setT1id(int t1id) {
		this.t1id = t1id;
	}

	public String getT2name() {
		return t2name;
	}

	public void setT2name(String t2name) {
		this.t2name = t2name;
	}

	public Date getT2create() {
		return t2create;
	}

	public void setT2create(Date t2create) {
		this.t2create = t2create;
	}

	public Date getT2remove() {
		return t2remove;
	}

	public void setT2remove(Date t2remove) {
		this.t2remove = t2remove;
	}

}
