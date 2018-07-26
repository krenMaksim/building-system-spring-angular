package com.mkren.building.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mkren.building.entity.RecordsArchiveEntity;

public interface RecordsArchiveDaoSpringData extends CrudRepository<RecordsArchiveEntity, Integer> {

    List<RecordsArchiveEntity> findByMagazineId(Integer magazineId);
}
