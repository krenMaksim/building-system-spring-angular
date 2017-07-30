package com.mkren.building.service;

import java.util.List;

import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.bean.SmetaBean;

public interface NewRecordService {
	public List<SmetaBean> getAllSmeta();

	public void storeNewRecord(NewRecordBean recordBean);
}
