package com.mkren.building.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mkren.building.entity.MagazineEntity;

public interface MagazineDaoSpringData extends CrudRepository<MagazineEntity, Integer> {
    @Override
    List<MagazineEntity> findAll();
}
