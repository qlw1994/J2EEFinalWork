package qlw.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "systemuser")
public class Systemuser {
	private String suid;
	private String suname;
	private String supwd;
	private int sutoheadcheck;
	private int sutogoodscheck;
	private Date sucreate;
	private Date suremove;

	@Id
	@GeneratedValue(generator = "assigned")
	@GenericGenerator(name = "assigned", strategy = "assigned")
	public String getSuid() {
		return suid;
	}

	public void setSuid(String suid) {
		this.suid = suid;
	}

	public String getSuname() {
		return suname;
	}

	public void setSuname(String suname) {
		this.suname = suname;
	}

	public String getSupwd() {
		return supwd;
	}

	public void setSupwd(String supwd) {
		this.supwd = supwd;
	}

	public int getSutoheadcheck() {
		return sutoheadcheck;
	}

	public void setSutoheadcheck(int sutoheadcheck) {
		this.sutoheadcheck = sutoheadcheck;
	}

	public int getSutogoodscheck() {
		return sutogoodscheck;
	}

	public void setSutogoodscheck(int sutogoodscheck) {
		this.sutogoodscheck = sutogoodscheck;
	}

	public Date getSucreate() {
		return sucreate;
	}

	public void setSucreate(Date sucreate) {
		this.sucreate = sucreate;
	}

	public Date getSuremove() {
		return suremove;
	}

	public void setSuremove(Date suremove) {
		this.suremove = suremove;
	}

}
