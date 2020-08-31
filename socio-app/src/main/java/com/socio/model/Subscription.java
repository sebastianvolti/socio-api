package com.socio.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.socio.repository.SubscriptionId;

@Entity
@IdClass(SubscriptionId.class)
@Table(name = "subscription_form")
public class Subscription{

	@Id
	private String email;

	@Id
	private Long club_id;

	private String token_account;

	private String payment_id;

	private Long subs_ammount;

	private Timestamp tiempo;

	public Subscription() {
		super();
	}


	public Subscription(String email, Long club_id, String token_account, String payment_id, Long subs_ammount, Timestamp tiempo) {
		super();
		this.email = email;
		this.club_id = club_id;
		this.token_account = token_account;
		this.payment_id = payment_id;
		this.subs_ammount = subs_ammount;
		this.tiempo = tiempo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public Long getClub_id() {
		return club_id;
	}


	public void setClub_id(Long club_id) {
		this.club_id = club_id;
	}


	public Timestamp getTiempo() {
		return tiempo;
	}


	public void setTiempo(Timestamp tiempo) {
		this.tiempo = tiempo;
	}


	public String getToken_account() {
		return token_account;
	}


	public void setToken_account(String token_account) {
		this.token_account = token_account;
	}


	public String getPayment_id() {
		return payment_id;
	}


	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}


	public Long getSubs_ammount() {
		return subs_ammount;
	}


	public void setSubs_ammount(Long subs_ammount) {
		this.subs_ammount = subs_ammount;
	}







}
