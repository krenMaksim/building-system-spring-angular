package com.mkren.building.service.impl;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.bean.UserBean;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.entity.RecordsArchiveEntity;
import com.mkren.building.entity.UserEntity;
import com.mkren.building.service.RedactorService;

@Service("redactorService")
public final class RedactorServiceImpl extends AbstractService implements RedactorService {
	private static final String SMENA = "smena";
	private static final String DATE = "date_";
	private static final String SMETA = "id_smeta";
	private static final String LOCATION = "location";
	private static final String WEATHER = "weather";
	private static final String CONDITIONS = "conditions";
	private static final String KOL_VO = "volume";
	private static final String CONTROLE = "controle";
	private static final String ID_USER = "id_user";

	// @Override
	// public NewRecordBean loadRecord(Integer id) {
	// MagazineEntity entity = magazineDao.loadMagazineById(id);
	// NewRecordBean bean = beanGenerator.createNewRecordBean(entity);
	//
	// return bean;
	// }

	// @Override
	// public List<UserBean> loadAllUsers() {
	//
	// List<UserEntity> entities = userDao.loadAllUsers();
	// List<UserBean> beans = new ArrayList<UserBean>();
	//
	// for (UserEntity entity : entities) {
	// UserBean bean = beanGenerator.creatUserBean(entity);
	// beans.add(bean);
	// }
	//
	// return beans;
	// }

	@Override
	public void updateRecord(NewRecordBean newRecord, NewRecordBean oldRecord, UserBean author, Integer magazineId) {
		// обновление всей записи
		boolean records = isEquals(newRecord, oldRecord);
		if (records) {
			return;
		} else {
			MagazineEntity entity = beanGenerator.createMagazineEntity(newRecord);
			entity.setId(magazineId);
			magazineDao.updateMagazine(entity);
		}

		// добавляем данные в таблицу исправлений
		RecordsArchiveEntity entity = null;

		boolean smena = isEquals(newRecord.getSmena(), oldRecord.getSmena());
		if (!smena) {
			entity = preparedEntity(oldRecord, author, magazineId);
			entity.setNameColumn(SMENA);
			entity.setOldRecord(oldRecord.getSmena());
			archiveDao.storeRecordsArchive(entity);
		}

		boolean date = isEquals(newRecord.getDate(), oldRecord.getDate());
		if (!date) {
			entity = preparedEntity(oldRecord, author, magazineId);
			entity.setNameColumn(DATE);
			entity.setOldRecord(oldRecord.getDate().toString());
			archiveDao.storeRecordsArchive(entity);
		}

		boolean ppSmeta = isEquals(newRecord.getPpSmeta(), oldRecord.getPpSmeta());
		if (!ppSmeta) {
			entity = preparedEntity(oldRecord, author, magazineId);
			entity.setNameColumn(SMETA);
			Integer idSmeta = smetaDao.loadSmetaByPp(oldRecord.getPpSmeta()).getPp();
			if (idSmeta != null) {
				entity.setOldRecord(idSmeta.toString());
				archiveDao.storeRecordsArchive(entity);
			}
		}

		boolean location = isEquals(newRecord.getLocation(), oldRecord.getLocation());
		if (!location) {
			entity = preparedEntity(oldRecord, author, magazineId);
			entity.setNameColumn(LOCATION);
			entity.setOldRecord(oldRecord.getLocation());
			archiveDao.storeRecordsArchive(entity);
		}

		boolean weather = isEquals(newRecord.getWeather(), oldRecord.getWeather());
		if (!weather) {
			entity = preparedEntity(oldRecord, author, magazineId);
			entity.setNameColumn(WEATHER);
			entity.setOldRecord(oldRecord.getWeather());
			archiveDao.storeRecordsArchive(entity);
		}

		boolean conditions = isEquals(newRecord.getConditions(), oldRecord.getConditions());
		if (!conditions) {
			entity = preparedEntity(oldRecord, author, magazineId);
			entity.setNameColumn(CONDITIONS);
			entity.setOldRecord(oldRecord.getConditions());
			archiveDao.storeRecordsArchive(entity);
		}

		boolean kolVo = isEquals(newRecord.getKolVo(), oldRecord.getKolVo());
		if (!kolVo) {
			entity = preparedEntity(oldRecord, author, magazineId);
			entity.setNameColumn(KOL_VO);
			entity.setOldRecord(oldRecord.getKolVo().toString());
			archiveDao.storeRecordsArchive(entity);
		}

		boolean controle = isEquals(newRecord.getControle(), oldRecord.getControle());
		if (!controle) {
			entity = preparedEntity(oldRecord, author, magazineId);
			entity.setNameColumn(CONTROLE);
			entity.setOldRecord(oldRecord.getControle());
			archiveDao.storeRecordsArchive(entity);
		}

		boolean userId = isEquals(newRecord.getUserId(), oldRecord.getUserId());
		if (!userId) {
			entity = preparedEntity(oldRecord, author, magazineId);
			entity.setNameColumn(ID_USER);
			entity.setOldRecord(oldRecord.getUserId().toString());
			archiveDao.storeRecordsArchive(entity);
		}
	}

	private RecordsArchiveEntity preparedEntity(NewRecordBean oldRecord, UserBean author, Integer magazineId) {
		RecordsArchiveEntity entity = new RecordsArchiveEntity();
		// entity.setIdMag(magazineId);
		MagazineEntity magazineEntity = magazineDao.loadMagazineById(magazineId);
		entity.setMagazine(magazineEntity);

		entity.setDate(new Date(System.currentTimeMillis()));

		// entity.setIdUser(author.getId());
		UserEntity userEntity = userDao.loadUserById(author.getId());
		entity.setUser(userEntity);

		return entity;
	}

	private <T> boolean isEquals(T objectOne, T objectTwo) {
		if (objectOne == null && objectTwo == null) {
			return true;
		}

		if (objectOne == null || objectTwo == null) {
			return false;
		}

		return objectOne.equals(objectTwo);
	}
}