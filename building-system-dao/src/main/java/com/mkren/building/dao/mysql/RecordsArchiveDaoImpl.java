package com.mkren.building.dao.mysql;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mkren.building.dao.RecordsArchiveDAO;
import com.mkren.building.entity.RecordsArchiveEntity;

@Repository("recordsArchiveDao")
@Transactional(readOnly = false)
public class RecordsArchiveDaoImpl extends BaseDao implements RecordsArchiveDAO {

    @Autowired
    private RecordsArchiveDaoSpringData recordsArchiveDaoSpringData;

    @Override
    public RecordsArchiveEntity loadRecordsArchiveById(Integer recordId) {
	Objects.requireNonNull(recordId);

	return recordsArchiveDaoSpringData.findById(recordId)
	                                  .orElse(null);
    }

    @Override
    public RecordsArchiveEntity storeRecordsArchive(RecordsArchiveEntity record) {
	Objects.requireNonNull(record);

	return recordsArchiveDaoSpringData.save(record);
    }

    @Override
    public List<RecordsArchiveEntity> loadRecordsArchiveByMagazineId(Integer magazineId) {
	Objects.requireNonNull(magazineId);

	return recordsArchiveDaoSpringData.findByMagazineId(magazineId);
    }
}