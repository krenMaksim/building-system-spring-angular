package com.mkren.building.bean;

import java.io.Serializable;

public class SmetaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer pp;
    private String obosnovanie;
    private String naimenovanie;
    private String edIzm;
    private Double kolVo;
    private Double rest;

    public SmetaBean() {
	super();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getPp() {
	return pp;
    }

    public void setPp(Integer pp) {
	this.pp = pp;
    }

    public String getObosnovanie() {
	return obosnovanie;
    }

    public void setObosnovanie(String obosnovanie) {
	this.obosnovanie = obosnovanie;
    }

    public String getNaimenovanie() {
	return naimenovanie;
    }

    public void setNaimenovanie(String naimenovanie) {
	this.naimenovanie = naimenovanie;
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

    public Double getRest() {
	return rest;
    }

    public void setRest(Double rest) {
	this.rest = rest;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((edIzm == null) ? 0 : edIzm.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((kolVo == null) ? 0 : kolVo.hashCode());
	result = prime * result + ((naimenovanie == null) ? 0 : naimenovanie.hashCode());
	result = prime * result + ((obosnovanie == null) ? 0 : obosnovanie.hashCode());
	result = prime * result + ((pp == null) ? 0 : pp.hashCode());
	result = prime * result + ((rest == null) ? 0 : rest.hashCode());
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
	SmetaBean other = (SmetaBean) obj;
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
	if (kolVo == null) {
	    if (other.kolVo != null) {
		return false;
	    }
	} else if (!kolVo.equals(other.kolVo)) {
	    return false;
	}
	if (naimenovanie == null) {
	    if (other.naimenovanie != null) {
		return false;
	    }
	} else if (!naimenovanie.equals(other.naimenovanie)) {
	    return false;
	}
	if (obosnovanie == null) {
	    if (other.obosnovanie != null) {
		return false;
	    }
	} else if (!obosnovanie.equals(other.obosnovanie)) {
	    return false;
	}
	if (pp == null) {
	    if (other.pp != null) {
		return false;
	    }
	} else if (!pp.equals(other.pp)) {
	    return false;
	}
	if (rest == null) {
	    if (other.rest != null) {
		return false;
	    }
	} else if (!rest.equals(other.rest)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "SmetaBean [pp=" + pp + ", obosnovanie=" + obosnovanie + ", naimenovanie=" + naimenovanie + ", edIzm=" + edIzm + ", kolVo=" + kolVo + ", rest=" + rest + "]";
    }

}
