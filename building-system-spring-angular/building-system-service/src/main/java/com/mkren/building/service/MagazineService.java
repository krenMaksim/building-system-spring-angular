package com.mkren.building.service;

import java.sql.Date;
import java.util.List;

import com.mkren.building.bean.MagazineBean;
import com.mkren.building.bean.NewRecordBean;

public interface MagazineService {
	public List<MagazineBean> getRecords(Date dateWith, Date dateOn, List<String> surnames);

	public NewRecordBean getOldRecord(Integer magazineId);

	public List<String> surnameInitials();
}
