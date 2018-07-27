package com.mkren.building.dao.mysql;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mkren.building.entity.RecordsArchiveEntity;

interface RecordsArchiveDaoSpringData extends CrudRepository<RecordsArchiveEntity, Integer> {

    List<RecordsArchiveEntity> findByMagazineId(Integer magazineId);
}
