package com.socio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "club_form")
public class Club {


	@Id
	private Long club_id;

	private String club_name;

	private String club_dir;

	private Long club_ammount;

	public Club() {
		super();
	}


	public Club(Long club_id, String club_name, String club_dir, Long club_ammount) {
		super();
		this.club_id = club_id;
		this.club_name = club_name;
		this.club_dir = club_dir;
		this.club_ammount = club_ammount;
	}

	public Long getClub_id() {
		return club_id;
	}

	public void setClub_id(Long club_id) {
		this.club_id = club_id;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public String getClub_dir() {
		return club_dir;
	}

	public void setClub_dir(String club_dir) {
		this.club_dir = club_dir;
	}

	public Long getClub_ammount() {
		return club_ammount;
	}

	public void setClub_ammount(Long club_ammount) {
		this.club_ammount = club_ammount;
	}



}
