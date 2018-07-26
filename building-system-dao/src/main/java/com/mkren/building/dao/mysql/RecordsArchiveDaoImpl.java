package com.mkren.building.dao.mysql;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mkren.building.dao.RecordsArchiveDAO;
import com.mkren.building.entity.RecordsArchiveEntity;
import com.mkren.building.repo.RecordsArchiveDaoSpringData;

@Repository("recordsArchiveDao")
@Transactional(readOnly = false)
public class RecordsArchiveDaoImpl extends BaseDao implements RecordsArchiveDAO {

    @Autowired
    private RecordsArchiveDaoSpringData recordsArchiveDaoSpringData;

    @Override
    public RecordsArchiveEntity loadRecordsArchiveById(Integer recordId) {
	Objects.requireNonNull(recordId);

	// return manager.find(RecordsArchiveEntity.class, recordId);

	return recordsArchiveDaoSpringData.findById(recordId)
	                                  .orElse(null);
    }

    @Override
    public RecordsArchiveEntity storeRecordsArchive(RecordsArchiveEntity record) {
	Objects.requireNonNull(record);

	// return manager.merge(record);

	return recordsArchiveDaoSpringData.save(record);
    }

    @Override
    public List<RecordsArchiveEntity> loadRecordsArchiveByMagazineId(Integer magazineId) {
	Objects.requireNonNull(magazineId);

	// Query query = manager.createQuery("SELECT rec FROM RecordsArchiveEntity rec WHERE rec.magazine.id = :magazineId");
	// query.setParameter("magazineId", magazineId);
	//
	// return query.getResultList();

	return recordsArchiveDaoSpringData.findByMagazineId(magazineId);
    }
}