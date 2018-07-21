package com.mkren.building.dao.mysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkren.building.dao.UserDAO;

class UserDaoImplTest extends AbstractDaoTest {

    @Autowired
    private UserDAO userDao;

    @Test
    void test() {
	userDao.loadAllUsers()
	       .forEach(i -> System.out.println(i));
    }

    @Test
    void test2() {
	userDao.loadAllUsers()
	       .forEach(i -> System.out.println(i));
    }

}
