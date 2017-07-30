package com.mkren.building.dao;

import java.util.List;

import com.mkren.building.entity.RecordsArchiveEntity;

public interface RecordsArchiveDAO {

	public RecordsArchiveEntity loadRecordsArchiveById(Integer recordId);

	public RecordsArchiveEntity storeRecordsArchive(RecordsArchiveEntity record);

	public List<RecordsArchiveEntity> loadRecordsArchiveByMagazineId(Integer magazineId);
}
