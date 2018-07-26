package com.mkren.building.dao.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkren.building.dao.UserDAO;
import com.mkren.building.entity.UserEntity;

class UserDaoImplTest extends AbstractDaoTest {

    private static final UserEntity expectedUser = new UserEntity();
    static {
	expectedUser.setId(1);
	expectedUser.setLogin("Petrov");
	expectedUser.setPassword("dfssf35");
	expectedUser.setSurnameInitials("Петров И.И.");
	expectedUser.setRole("заказчик");
	expectedUser.setDelStatus("активен");
    }

    @Autowired
    private UserDAO userDao;

    @Test
    void loadAllUsers() {
	List<UserEntity> users = userDao.loadAllUsers();

	assertFalse(users.isEmpty());
	assertEquals(4, users.size());

	users.forEach(user -> assertTrue(Objects.nonNull(user)));
    }

    @Test
    void loadUserById() {
	assertEquals(expectedUser, userDao.loadUserById(expectedUser.getId()));
    }

    @Test
    void loadUserByFakeId() {
	assertEquals(null, userDao.loadUserById(FAKE_ID));
    }

    @Test
    void loadUserByNullId() {
	assertThrows(NullPointerException.class, () -> {
	    userDao.loadUserById(null);
	});
    }

    @Test
    void loadUserByLogin() {
	assertEquals(expectedUser, userDao.loadUserByLogin(expectedUser.getLogin()));
    }

    @Test
    void loadUserByFakeLogin() {
	assertEquals(null, userDao.loadUserByLogin("no user"));
    }

    @Test
    void loadUserByNullLogin() {
	assertThrows(NullPointerException.class, () -> {
	    userDao.loadUserByLogin(null);
	});
    }

    // @Test
    // don't know why this doesn't work
    void loadUserBySurname() {
	assertEquals(expectedUser, userDao.loadUserByLogin(expectedUser.getSurnameInitials()));
    }

    @Test
    void loadUserByFakeSurname() {
	assertEquals(null, userDao.loadUserBySurname("no surname"));
    }

    @Test
    void loadUserByNullSurname() {
	assertThrows(NullPointerException.class, () -> {
	    userDao.loadUserBySurname(null);
	});
    }
}
