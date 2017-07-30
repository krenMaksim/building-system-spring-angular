package com.mkren.building.bean;

import java.io.Serializable;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String login;
	private String password;
	private String surnameInitials;
	private String role;

	public UserBean() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurnameInitials() {
		return surnameInitials;
	}

	public void setSurnameInitials(String surnameInitials) {
		this.surnameInitials = surnameInitials;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", login=" + login + ", password=" + password + ", surnameInitials=" + surnameInitials + ", role=" + role + "]";
	}

}
