package com.mkren.building.dao.mysql;

import java.util.List;
import java.util.Objects;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mkren.building.dao.RecordsArchiveDAO;
import com.mkren.building.entity.RecordsArchiveEntity;

@Repository("recordsArchiveDao")
@Transactional(readOnly = false)
public class RecordsArchiveDaoImpl extends BaseDao implements RecordsArchiveDAO {

    @Override
    public RecordsArchiveEntity loadRecordsArchiveById(Integer recordId) {
	Objects.requireNonNull(recordId);

	return manager.find(RecordsArchiveEntity.class, recordId);
    }

    @Override
    public RecordsArchiveEntity storeRecordsArchive(RecordsArchiveEntity record) {
	Objects.requireNonNull(record);

	return manager.merge(record);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RecordsArchiveEntity> loadRecordsArchiveByMagazineId(Integer magazineId) {
	Objects.requireNonNull(magazineId);

	Query query = manager.createQuery("SELECT rec FROM RecordsArchiveEntity rec WHERE rec.magazine.id = :magazineId");
	query.setParameter("magazineId", magazineId);

	return query.getResultList();
    }
}