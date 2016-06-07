package qlw.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "message")
public class Messages {
	private int mid;
	private String mcontent;
	private String mstate;
	private String mfrom;
	private String mto;
	private Date mcreate;
	private Date mremove;

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public String getMstate() {
		return mstate;
	}

	public void setMstate(String mstate) {
		this.mstate = mstate;
	}

	public String getMfrom() {
		return mfrom;
	}

	public void setMfrom(String mfrom) {
		this.mfrom = mfrom;
	}

	public String getMto() {
		return mto;
	}

	public void setMto(String mto) {
		this.mto = mto;
	}

	public Date getMcreate() {
		return mcreate;
	}

	public void setMcreate(Date mcreate) {
		this.mcreate = mcreate;
	}

	public Date getMremove() {
		return mremove;
	}

	public void setMremove(Date mremove) {
		this.mremove = mremove;
	}

}
