package com.mkren.building.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "smeta")
public class SmetaEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "pp")
	private Integer pp;

	@Column(name = "obosnovanie")
	private String obosnovanie;

	@Column(name = "naimenovanie")
	private String naimenovanie;

	@Column(name = "ed_izm")
	private String edIzm;

	@Column(name = "kol_vo")
	private Double kolVo;

	public SmetaEntity() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((edIzm == null) ? 0 : edIzm.hashCode());
		result = prime * result + ((kolVo == null) ? 0 : kolVo.hashCode());
		result = prime * result + ((naimenovanie == null) ? 0 : naimenovanie.hashCode());
		result = prime * result + ((obosnovanie == null) ? 0 : obosnovanie.hashCode());
		result = prime * result + ((pp == null) ? 0 : pp.hashCode());
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

		SmetaEntity other = (SmetaEntity) obj;

		if (edIzm == null) {
			if (other.edIzm != null) {
				return false;
			}
		} else if (!edIzm.equals(other.edIzm)) {
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

		return true;
	}

	@Override
	public String toString() {
		return "SmetaEntity [id=" + getId() + ", pp=" + pp + ", obosnovanie=" + obosnovanie + ", naimenovanie=" + naimenovanie + ", edIzm=" + edIzm + ", kolVo=" + kolVo + "]";
	}
}
