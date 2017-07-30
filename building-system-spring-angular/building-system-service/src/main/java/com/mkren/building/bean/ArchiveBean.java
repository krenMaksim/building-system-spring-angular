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
	public String toString() {
		return "ArchiveBean [date=" + date + ", smena=" + smena + ", location=" + location + ", obosnovanie=" + obosnovanie + ", weather=" + weather + ", conditions=" + conditions + ", kolVo=" + kolVo + ", controle=" + controle + ", surnameInitials="
				+ surnameInitials + "]";
	}
}