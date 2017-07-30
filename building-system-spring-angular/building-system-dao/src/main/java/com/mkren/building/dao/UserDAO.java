package com.mkren.building.dao;

import java.util.List;

import com.mkren.building.entity.UserEntity;

public interface UserDAO {
	public List<UserEntity> loadAllUsers();

	public UserEntity loadUserById(Integer userId);

	public UserEntity loadUserBySurname(String surname);

	public UserEntity loadUserByLogin(String login);

}
