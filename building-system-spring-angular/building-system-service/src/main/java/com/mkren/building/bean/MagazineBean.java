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
	public String toString() {
		return "MagazineBean [id=" + id + ", date=" + date + ", smena=" + smena + ", location=" + location + ", obosnovanie=" + obosnovanie + ", weather=" + weather + ", conditions=" + conditions + ", edIzm=" + edIzm + ", kolVo=" + kolVo
				+ ", controle=" + controle + ", surnameInitials=" + surnameInitials + ", role=" + role + ", archive=" + archive + "]";
	}

}