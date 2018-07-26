package com.mkren.building.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users_")
public class UserEntity extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "surname_initials")
    private String surnameInitials;

    @Column(name = "role")
    private String role;

    @Column(name = "del_status")
    private String delStatus;

    public UserEntity() {
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

    public String getDelStatus() {
	return delStatus;
    }

    public void setDelStatus(String delStatus) {
	this.delStatus = delStatus;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((delStatus == null) ? 0 : delStatus.hashCode());
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

	if (!super.equals(obj)) {
	    return false;
	}

	if (getClass() != obj.getClass()) {
	    return false;
	}

	UserEntity other = (UserEntity) obj;

	if (delStatus == null) {
	    if (other.delStatus != null) {
		return false;
	    }
	} else if (!delStatus.equals(other.delStatus)) {
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
	return "UserEntity [id=" + getId() + ", login=" + login + ", password=" + password + ", surnameInitials=" + surnameInitials + ", role=" + role + ", delStatus=" + delStatus + "]";
    }
}
