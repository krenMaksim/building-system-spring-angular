package com.mkren.building.dao.mysql;

import java.util.List;
import java.util.Objects;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mkren.building.dao.UserDAO;
import com.mkren.building.entity.UserEntity;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDAO {

    @Override
    public List<UserEntity> loadAllUsers() {
	return manager.createQuery("SELECT u FROM UserEntity u", UserEntity.class)
	              .getResultList();
    }

    @Override
    public UserEntity loadUserById(Integer userId) {
	Objects.requireNonNull(userId);

	return manager.find(UserEntity.class, userId);
    }

    @Override
    public UserEntity loadUserByLogin(String login) {
	Objects.requireNonNull(login);

	Query query = manager.createQuery("SELECT u FROM UserEntity u WHERE u.login = :login");
	query.setParameter("login", login);

	try {
	    return (UserEntity) query.getSingleResult();
	} catch (NoResultException e) {
	    return null;
	}
    }

    @Override
    public UserEntity loadUserBySurname(String surname) {
	Objects.requireNonNull(surname);

	Query query = manager.createQuery("SELECT u FROM UserEntity u WHERE u.surnameInitials = :surname");
	query.setParameter("surname", surname);

	try {
	    return (UserEntity) query.getSingleResult();
	} catch (NoResultException e) {
	    return null;
	}
    }
}
