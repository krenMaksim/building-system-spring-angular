package com.mkren.building.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mkren.building.entity.UserEntity;

public interface UserDaoSpringData extends CrudRepository<UserEntity, Integer> {

    @Override
    List<UserEntity> findAll();

    UserEntity findByLogin(String login);

    UserEntity findBySurnameInitials(String surname);
}
