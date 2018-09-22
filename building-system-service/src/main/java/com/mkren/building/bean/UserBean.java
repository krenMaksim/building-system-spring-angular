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
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((login == null) ? 0 : login.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	result = prime * result + ((surnameInitials == null) ? 0 : surnameInitials.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	UserBean other = (UserBean) obj;
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	if (login == null) {
	    if (other.login != null) {
		return false;
	    }
	} else if (!login.equals(other.login)) {
	    return false;
	}
	if (password == null) {
	    if (other.password != null) {
		return false;
	    }
	} else if (!password.equals(other.password)) {
	    return false;
	}
	if (role == null) {
	    if (other.role != null) {
		return false;
	    }
	} else if (!role.equals(other.role)) {
	    return false;
	}
	if (surnameInitials == null) {
	    if (other.surnameInitials != null) {
		return false;
	    }
	} else if (!surnameInitials.equals(other.surnameInitials)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "UserBean [id=" + id + ", login=" + login + ", password=" + password + ", surnameInitials=" + surnameInitials + ", role=" + role + "]";
    }

}
