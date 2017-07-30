package com.mkren.building.service;

import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.bean.UserBean;

public interface RedactorService {
	// public NewRecordBean loadRecord(Integer id);

	// public List<UserBean> loadAllUsers();

	public void updateRecord(NewRecordBean newRecord, NewRecordBean oldRecord, UserBean author, Integer magazineId);
}
