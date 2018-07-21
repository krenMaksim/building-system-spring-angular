package com.mkren.building.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.bean.SmetaBean;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.entity.SmetaEntity;
import com.mkren.building.service.NewRecordService;

@Service("newRecordService")
public final class NewRecordServiceImpl extends AbstractService implements NewRecordService {

	@Override
	public List<SmetaBean> getAllSmeta() {
		List<SmetaEntity> listEntity = smetaDao.loadAllSmeta();

		List<SmetaBean> listBeans = new ArrayList<SmetaBean>();

		for (SmetaEntity entity : listEntity) {
			SmetaBean bean = beanGenerator.createSmetaBean(entity);
			listBeans.add(bean);
		}

		return listBeans;
	}

	@Override
	public void storeNewRecord(NewRecordBean recordBean) {
		MagazineEntity magazine = beanGenerator.createMagazineEntity(recordBean);
		magazineDao.storeMagazine(magazine);
	}
}
