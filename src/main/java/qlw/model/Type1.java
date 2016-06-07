package qlw.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "type1")
public class Type1 {
	private int t1id;
	private String t1name;
	private Date t1create;
	private Date t1remove;

	@Id
	@GeneratedValue(generator = "identity")
	@GenericGenerator(name = "identity", strategy = "identity")
	public int getT1id() {
		return t1id;
	}

	public void setT1id(int t1id) {
		this.t1id = t1id;
	}

	public String getT1name() {
		return t1name;
	}

	public void setT1name(String t1name) {
		this.t1name = t1name;
	}

	public Date getT1create() {
		return t1create;
	}

	public void setT1create(Date t1create) {
		this.t1create = t1create;
	}

	public Date getT1remove() {
		return t1remove;
	}

	public void setT1remove(Date t1remove) {
		this.t1remove = t1remove;
	}

}
