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
		super();
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
	public String toString() {
		return "NewRecordBean [smena=" + smena + ", date=" + date + ", ppSmeta=" + ppSmeta + ", location=" + location + ", weather=" + weather + ", conditions=" + conditions + ", kolVo=" + kolVo + ", controle=" + controle + ", userId=" + userId
				+ "]";
	}

}
