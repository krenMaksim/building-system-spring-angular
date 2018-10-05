package com.mkren.building.bean;

import java.io.Serializable;

public class ArchiveBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String date;
    private String smena;
    private String location;
    private String obosnovanie;
    private String weather;
    private String conditions;
    private String kolVo;
    private String controle;
    private String surnameInitials;

    public ArchiveBean() {
	super();
    }

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public String getSmena() {
	return smena;
    }

    public void setSmena(String smena) {
	this.smena = smena;
    }

    public String getLocation() {
	return location;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    public String getObosnovanie() {
	return obosnovanie;
    }

    public void setObosnovanie(String obosnovanie) {
	this.obosnovanie = obosnovanie;
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

    public String getKolVo() {
	return kolVo;
    }

    public void setKolVo(String kolVo) {
	this.kolVo = kolVo;
    }

    public String getControle() {
	return controle;
    }

    public void setControle(String controle) {
	this.controle = controle;
    }

    public String getSurnameInitials() {
	return surnameInitials;
    }

    public void setSurnameInitials(String surnameInitials) {
	this.surnameInitials = surnameInitials;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((conditions == null) ? 0 : conditions.hashCode());
	result = prime * result + ((controle == null) ? 0 : controle.hashCode());
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((kolVo == null) ? 0 : kolVo.hashCode());
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	result = prime * result + ((obosnovanie == null) ? 0 : obosnovanie.hashCode());
	result = prime * result + ((smena == null) ? 0 : smena.hashCode());
	result = prime * result + ((surnameInitials == null) ? 0 : surnameInitials.hashCode());
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
	ArchiveBean other = (ArchiveBean) obj;
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
	} else if (!date.equals(other.date)) {
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
	if (obosnovanie == null) {
	    if (other.obosnovanie != null) {
		return false;
	    }
	} else if (!obosnovanie.equals(other.obosnovanie)) {
	    return false;
	}
	if (smena == null) {
	    if (other.smena != null) {
		return false;
	    }
	} else if (!smena.equals(other.smena)) {
	    return false;
	}
	if (surnameInitials == null) {
	    if (other.surnameInitials != null) {
		return false;
	    }
	} else if (!surnameInitials.equals(other.surnameInitials)) {
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
	return "ArchiveBean [date=" + date + ", smena=" + smena + ", location=" + location + ", obosnovanie=" + obosnovanie + ", weather=" + weather + ", conditions=" + conditions + ", kolVo=" + kolVo
	        + ", controle=" + controle + ", surnameInitials="
	        + surnameInitials + "]";
    }
}