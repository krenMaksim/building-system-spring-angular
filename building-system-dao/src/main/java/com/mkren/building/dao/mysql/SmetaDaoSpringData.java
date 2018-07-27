package com.mkren.building.dao.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mkren.building.entity.SmetaEntity;

interface SmetaDaoSpringData extends CrudRepository<SmetaEntity, Integer> {
    @Override
    List<SmetaEntity> findAll();

    SmetaEntity findByPp(Integer smetaPp);

    @Query(value = "" +
            "SELECT ROUND(sm.kolVo - SUM(COALESCE(mag.volume, 0)), 2) " +
            "FROM SmetaEntity sm LEFT OUTER JOIN MagazineEntity mag " +
            "ON sm.id = mag.smeta.id " +
            "WHERE sm.id = ?1 ")
    Double findRestFromVolumesById(Integer smetaId);
}
