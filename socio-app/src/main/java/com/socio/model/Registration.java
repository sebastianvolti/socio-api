package com.socio.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registration_form")
public class Registration {


	@Id
	private String email;

	private String pass;

	private String cid;

	String name;

	String last_name;

	private Timestamp tiempo;

	public Registration() {
		super();
	}

	public Registration(String email, String pass, String cid, Timestamp tiempo) {
		super();
		this.email = email;
		this.pass = pass;
		this.cid = cid;
		this.tiempo = tiempo;
	}

	public Registration(String email, String pass, String cid, Timestamp tiempo, String name, String last_name) {
		super();
		this.email = email;
		this.pass = pass;
		this.cid = cid;
		this.last_name = name;
		this.last_name = last_name;
		this.tiempo = tiempo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}


	public Timestamp getTiempo() {
		return tiempo;
	}

	public void setTiempo(Timestamp tiempo) {
		this.tiempo = tiempo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}






}
