package ru.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments", schema = "hr")
public class Dept implements Serializable {
	@Id
	@Column(name = "department_id")
	private int depno;
	@Column(name = "department_name")
	private String dname;
	
	public Dept() {
		super();
	}
	
	public int getDepno() {
		return depno;
	}
	public void setDepno(int depno) {
		this.depno = depno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Dept [depno=" + depno + ", dname=" + dname + "]";
	}
	
	
	
}
