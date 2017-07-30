package com.mkren.building.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "records_archive")
public class RecordsArchiveEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name = "id_mag")
	private MagazineEntity magazine;

	@Column(name = "date_")
	private Date date;

	@Column(name = "name_column")
	private String nameColumn;

	@Column(name = "old_record")
	private String oldRecord;

	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name = "id_user")
	private UserEntity user;

	public RecordsArchiveEntity() {
	}

	public MagazineEntity getMagazine() {
		return magazine;
	}

	public void setMagazine(MagazineEntity magazine) {
		this.magazine = magazine;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNameColumn() {
		return nameColumn;
	}

	public void setNameColumn(String nameColumn) {
		this.nameColumn = nameColumn;
	}

	public String getOldRecord() {
		return oldRecord;
	}

	public void setOldRecord(String oldRecord) {
		this.oldRecord = oldRecord;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((magazine == null) ? 0 : magazine.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((nameColumn == null) ? 0 : nameColumn.hashCode());
		result = prime * result + ((oldRecord == null) ? 0 : oldRecord.hashCode());
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

		RecordsArchiveEntity other = (RecordsArchiveEntity) obj;

		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}

		if (magazine == null) {
			if (other.magazine != null) {
				return false;
			}
		} else if (!magazine.equals(other.magazine)) {
			return false;
		}

		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}

		if (nameColumn == null) {
			if (other.nameColumn != null) {
				return false;
			}
		} else if (!nameColumn.equals(other.nameColumn)) {
			return false;
		}

		if (oldRecord == null) {
			if (other.oldRecord != null) {
				return false;
			}
		} else if (!oldRecord.equals(other.oldRecord)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "RecordsArchiveEntity [magazine=" + magazine + ", date=" + date + ", nameColumn=" + nameColumn + ", oldRecord=" + oldRecord + ", user=" + user + "]";
	}
}