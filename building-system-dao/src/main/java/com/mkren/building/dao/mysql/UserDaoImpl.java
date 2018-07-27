package com.mkren.building.dao.mysql;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkren.building.dao.UserDAO;
import com.mkren.building.entity.UserEntity;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDAO {

    @Autowired
    private UserDaoSpringData userDaoSpringData;

    @Override
    public List<UserEntity> loadAllUsers() {
	return userDaoSpringData.findAll();
    }

    @Override
    public UserEntity loadUserById(Integer userId) {
	Objects.requireNonNull(userId);

	return userDaoSpringData.findById(userId)
	                        .orElse(null);
    }

    @Override
    public UserEntity loadUserByLogin(String login) {
	Objects.requireNonNull(login);

	return userDaoSpringData.findByLogin(login);
    }

    @Override
    public UserEntity loadUserBySurname(String surname) {
	Objects.requireNonNull(surname);

	return userDaoSpringData.findBySurnameInitials(surname);
    }
}
