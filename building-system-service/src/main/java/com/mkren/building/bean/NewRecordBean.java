package com.mkren.building.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.mkren.building.service.util.DateUtils;

public class NewRecordBean implements Serializable {

    private static final long serialVersionUID = 1L;

    // new Field
    private Integer id;

    @Pattern(regexp = "^[1-3]$", message = "SMENA: put correct smena!")
    @NotNull(message = "SMENA: put correct smena!")
    private String smena;

    @NotNull(message = "DATE: may not be null!")
    private Date date;

    @NotNull(message = "PP_SMETA: may not be null!")
    private Integer ppSmeta;

    private String location;
    private String weather;
    private String conditions;
    private Double kolVo;
    private String controle;

    @NotNull(message = "USER_ID: may not be null!")
    private Integer userId;

    private Integer authorId;

    public NewRecordBean() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getSmena() {
	return smena;
    }

    public void setSmena(String smena) {
	this.smena = smena;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public void setDate(@NotEmpty String date) {

	java.util.Date dateD = DateUtils.parseDate(date);

	if (dateD == null) {
	    this.date = null;
	} else {
	    this.date = new Date(dateD.getTime());
	}
    }

    public Integer getPpSmeta() {
	return ppSmeta;
    }

    public void setPpSmeta(Integer ppSmeta) {
	this.ppSmeta = ppSmeta;
    }

    public String getLocation() {
	return location;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    public String getWeather() {
	return weather;
    }

    public void setWeather(String weather) {
	this.weather = weather;
    }

    public String getConditions() {
	return conditions;
    }

    public void setConditions(String conditions) {
	this.conditions = conditions;
    }

    public Double getKolVo() {
	return kolVo;
    }

    public void setKolVo(Double kolVo) {
	this.kolVo = kolVo;
    }

    public void setKolVo(String kolVo) {
	this.kolVo = Double.valueOf(kolVo);
    }

    public String getControle() {
	return controle;
    }

    public void setControle(String controle) {
	this.controle = controle;
    }

    public Integer getUserId() {
	return userId;
    }

    public void setUserId(Integer userId) {
	this.userId = userId;
    }

    public Integer getAuthorId() {
	return authorId;
    }

    public void setAuthorId(Integer authorId) {
	this.authorId = authorId;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
	result = prime * result + ((conditions == null) ? 0 : conditions.hashCode());
	result = prime * result + ((controle == null) ? 0 : controle.hashCode());
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((kolVo == null) ? 0 : kolVo.hashCode());
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	result = prime * result + ((ppSmeta == null) ? 0 : ppSmeta.hashCode());
	result = prime * result + ((smena == null) ? 0 : smena.hashCode());
	result = prime * result + ((userId == null) ? 0 : userId.hashCode());
	result = prime * result + ((weather == null) ? 0 : weather.hashCode());
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
	NewRecordBean other = (NewRecordBean) obj;
	if (authorId == null) {
	    if (other.authorId != null) {
		return false;
	    }
	} else if (!authorId.equals(other.authorId)) {
	    return false;
	}
	if (conditions == null) {
	    if (other.conditions != null) {
		return false;
	    }
	} else if (!conditions.equals(other.conditions)) {
	    return false;
	}
	if (controle == null) {
	    if (other.controle != null) {
		return false;
	    }
	} else if (!controle.equals(other.controle)) {
	    return false;
	}
	if (date == null) {
	    if (other.date != null) {
		return false;
	    }
	} else if (!date.toString()
	                .equals(other.date.toString())) {
	    return false;
	}
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	if (kolVo == null) {
	    if (other.kolVo != null) {
		return false;
	    }
	} else if (!kolVo.equals(other.kolVo)) {
	    return false;
	}
	if (location == null) {
	    if (other.location != null) {
		return false;
	    }
	} else if (!location.equals(other.location)) {
	    return false;
	}
	if (ppSmeta == null) {
	    if (other.ppSmeta != null) {
		return false;
	    }
	} else if (!ppSmeta.equals(other.ppSmeta)) {
	    return false;
	}
	if (smena == null) {
	    if (other.smena != null) {
		return false;
	    }
	} else if (!smena.equals(other.smena)) {
	    return false;
	}
	if (userId == null) {
	    if (other.userId != null) {
		return false;
	    }
	} else if (!userId.equals(other.userId)) {
	    return false;
	}
	if (weather == null) {
	    if (other.weather != null) {
		return false;
	    }
	} else if (!weather.equals(other.weather)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "NewRecordBean [id=" + id + ", smena=" + smena + ", date=" + date + ", ppSmeta=" + ppSmeta + ", location=" + location + ", weather=" + weather + ", conditions=" + conditions
	        + ", kolVo=" + kolVo + ", controle=" + controle + ", userId=" + userId + ", authorId=" + authorId + "]";
    }

}
