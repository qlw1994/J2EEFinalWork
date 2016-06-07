package qlw.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "log")
public class Logs {
	private int lgid;
	private String lgtype;
	private String lgpersontype;
	private String lgpersonid;
	private String lgcontent;
	private String lgtable;
	private Date lgcreate;
	private Date lgremove;

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	public int getLgid() {
		return lgid;
	}

	public void setLgid(int lgid) {
		this.lgid = lgid;
	}

	public String getLgtype() {
		return lgtype;
	}

	public void setLgtype(String lgtype) {
		this.lgtype = lgtype;
	}

	public String getLgpersontype() {
		return lgpersontype;
	}

	public void setLgpersontype(String lgpersontype) {
		this.lgpersontype = lgpersontype;
	}

	public String getLgpersonid() {
		return lgpersonid;
	}

	public void setLgpersonid(String lgpersonid) {
		this.lgpersonid = lgpersonid;
	}

	public String getLgcontent() {
		return lgcontent;
	}

	public void setLgcontent(String lgcontent) {
		this.lgcontent = lgcontent;
	}

	public String getLgtable() {
		return lgtable;
	}

	public void setLgtable(String lgtable) {
		this.lgtable = lgtable;
	}

	public Date getLgcreate() {
		return lgcreate;
	}

	public void setLgcreate(Date lgcreate) {
		this.lgcreate = lgcreate;
	}

	public Date getLgremove() {
		return lgremove;
	}

	public void setLgremove(Date lgremove) {
		this.lgremove = lgremove;
	}

}
