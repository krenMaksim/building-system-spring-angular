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
	public String toString() {
		return "SmetaBean [pp=" + pp + ", obosnovanie=" + obosnovanie + ", naimenovanie=" + naimenovanie + ", edIzm=" + edIzm + ", kolVo=" + kolVo + ", rest=" + rest + "]";
	}

}
