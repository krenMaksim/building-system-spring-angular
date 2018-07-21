package com.mkren.building.dao.mysql;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mkren.building.dao.UserDAO;
import com.mkren.building.entity.UserEntity;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDAO {

	@Override
	public List<UserEntity> loadAllUsers() {
		String query = "SELECT u FROM UserEntity u";

		return manager.createQuery(query, UserEntity.class).getResultList();
	}

	@Override
	public UserEntity loadUserById(Integer userId) {
		return manager.find(UserEntity.class, userId);
	}

	@Override
	public UserEntity loadUserByLogin(String login) {
		Query query = manager.createQuery("SELECT u FROM UserEntity u WHERE u.login = :login");
		query.setParameter("login", login);

		return (UserEntity) query.getSingleResult();
	}

	@Override
	public UserEntity loadUserBySurname(String surname) {
		Query query = manager.createQuery("SELECT u FROM UserEntity u WHERE u.surnameInitials = :surname");
		query.setParameter("surname", surname);

		return (UserEntity) query.getSingleResult();
	}
}
