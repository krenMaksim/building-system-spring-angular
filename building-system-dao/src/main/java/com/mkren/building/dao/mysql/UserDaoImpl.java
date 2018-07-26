package com.mkren.building.dao.mysql;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkren.building.dao.UserDAO;
import com.mkren.building.entity.UserEntity;
import com.mkren.building.repo.UserDaoSpringData;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDAO {

    @Autowired
    private UserDaoSpringData userDaoSpringData;

    @Override
    public List<UserEntity> loadAllUsers() {
	// return manager.createQuery("SELECT u FROM UserEntity u", UserEntity.class)
	// .getResultList();

	return userDaoSpringData.findAll();

    }

    @Override
    public UserEntity loadUserById(Integer userId) {

	Objects.requireNonNull(userId);

	// return manager.find(UserEntity.class, userId);

	return userDaoSpringData.findById(userId)
	                        .orElse(null);
    }

    @Override
    public UserEntity loadUserByLogin(String login) {
	Objects.requireNonNull(login);

	// Query query = manager.createQuery("SELECT u FROM UserEntity u WHERE u.login = :login");
	// query.setParameter("login", login);
	//
	// try {
	// return (UserEntity) query.getSingleResult();
	// } catch (NoResultException e) {
	// return null;
	// }

	return userDaoSpringData.findByLogin(login);
    }

    @Override
    public UserEntity loadUserBySurname(String surname) {
	Objects.requireNonNull(surname);

	// Query query = manager.createQuery("SELECT u FROM UserEntity u WHERE u.surnameInitials = :surname");
	// query.setParameter("surname", surname);
	//
	// try {
	// return (UserEntity) query.getSingleResult();
	// } catch (NoResultException e) {
	// return null;
	// }

	return userDaoSpringData.findBySurnameInitials(surname);
    }
}
