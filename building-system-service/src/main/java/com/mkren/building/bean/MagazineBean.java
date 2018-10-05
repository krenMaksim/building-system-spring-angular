package com.mkren.building.bean;

import java.io.Serializable;
import java.sql.Date;

public class MagazineBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date date;
    private String smena;
    private String location;
    private String obosnovanie;
    // insert
    private Integer idSmeta;

    private String weather;
    private String conditions;
    private String edIzm;
    private Double kolVo;
    private String controle;
    private String surnameInitials;
    private String role;

    private Integer userId;

    // СОДЕРЖИТ бин архивных записей
    private ArchiveBean archive;

    public MagazineBean() {
	super();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
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

    public Integer getIdSmeta() {
	return idSmeta;
    }

    public void setIdSmeta(Integer idSmeta) {
	this.idSmeta = idSmeta;
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

    public String getEdIzm() {
	return edIzm;
    }

    public void setEdIzm(String edIzm) {
	this.edIzm = edIzm;
    }

    public Double getKolVo() {
	return kolVo;
    }

    public void setKolVo(Double kolVo) {
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

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    public Integer getUserId() {
	return userId;
    }

    public void setUserId(Integer userId) {
	this.userId = userId;
    }

    public ArchiveBean getArchive() {
	return archive;
    }

    public void setArchive(ArchiveBean archive) {
	this.archive = archive;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((archive == null) ? 0 : archive.hashCode());
	result = prime * result + ((conditions == null) ? 0 : conditions.hashCode());
	result = prime * result + ((controle == null) ? 0 : controle.hashCode());
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((edIzm == null) ? 0 : edIzm.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((idSmeta == null) ? 0 : idSmeta.hashCode());
	result = prime * result + ((kolVo == null) ? 0 : kolVo.hashCode());
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	result = prime * result + ((obosnovanie == null) ? 0 : obosnovanie.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	result = prime * result + ((smena == null) ? 0 : smena.hashCode());
	result = prime * result + ((surnameInitials == null) ? 0 : surnameInitials.hashCode());
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
	MagazineBean other = (MagazineBean) obj;
	if (archive == null) {
	    if (other.archive != null) {
		return false;
	    }
	} else if (!archive.equals(other.archive)) {
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
	} else if (!date.equals(other.date)) {
	    return false;
	}
	if (edIzm == null) {
	    if (other.edIzm != null) {
		return false;
	    }
	} else if (!edIzm.equals(other.edIzm)) {
	    return false;
	}
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	if (idSmeta == null) {
	    if (other.idSmeta != null) {
		return false;
	    }
	} else if (!idSmeta.equals(other.idSmeta)) {
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
	if (role == null) {
	    if (other.role != null) {
		return false;
	    }
	} else if (!role.equals(other.role)) {
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
	return "MagazineBean [id=" + id + ", date=" + date + ", smena=" + smena + ", location=" + location + ", obosnovanie=" + obosnovanie + ", weather=" + weather + ", conditions=" + conditions
	        + ", edIzm=" + edIzm + ", kolVo=" + kolVo
	        + ", controle=" + controle + ", surnameInitials=" + surnameInitials + ", role=" + role + ", archive=" + archive + "]";
    }

}