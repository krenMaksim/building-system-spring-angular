package com.mkren.building.dao.mysql;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mkren.building.entity.UserEntity;

interface UserDaoSpringData extends CrudRepository<UserEntity, Integer> {

    @Override
    List<UserEntity> findAll();

    UserEntity findByLogin(String login);

    UserEntity findBySurnameInitials(String surname);
}
