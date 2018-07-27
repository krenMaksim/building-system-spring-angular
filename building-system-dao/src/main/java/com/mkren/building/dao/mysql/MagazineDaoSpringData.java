package com.mkren.building.dao.mysql;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mkren.building.entity.MagazineEntity;

interface MagazineDaoSpringData extends CrudRepository<MagazineEntity, Integer> {
    @Override
    List<MagazineEntity> findAll();
}
