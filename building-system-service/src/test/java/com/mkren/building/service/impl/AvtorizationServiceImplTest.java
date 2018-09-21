package com.mkren.building.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkren.building.bean.UserBean;
import com.mkren.building.entity.UserEntity;
import com.mkren.building.service.AbstractServiceTest;
import com.mkren.building.service.AvtorizationService;

class AvtorizationServiceImplTest extends AbstractServiceTest {

    @Autowired
    private AvtorizationService avtorizationService;

    private UserEntity userEntity;

    private UserBean userBean;

    @BeforeEach
    private void init() {
	userEntity = new UserEntity();
	userEntity.setId(1);
	userEntity.setLogin("Petrov");
	userEntity.setPassword("dfssf35");
	userEntity.setSurnameInitials("Петров И.И.");
	userEntity.setRole("заказчик");
	userEntity.setDelStatus("активен");

	userBean = new UserBean();
	userBean.setId(userEntity.getId());
	userBean.setLogin(userEntity.getLogin());
	userBean.setPassword(userEntity.getPassword());
	userBean.setSurnameInitials(userEntity.getSurnameInitials());
	userBean.setRole(userEntity.getRole());

    }

    @Test
    void loadUserBeanByLogin() {
	avtorizationService.loadUserBeanByLogin("null");
    }
}
