package com.mkren.building.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkren.building.bean.UserBean;
import com.mkren.building.dao.UserDAO;
import com.mkren.building.entity.UserEntity;
import com.mkren.building.service.AvtorizationService;
import com.mkren.building.service.generator.BeanGenerator;

@Service("avtorizationService")
public class AvtorizationServiceImpl implements AvtorizationService {

    private final UserDAO userDao;
    private final BeanGenerator beanGenerator;

    @Autowired
    public AvtorizationServiceImpl(UserDAO userDao, BeanGenerator beanGenerator) {
	this.userDao = userDao;
	this.beanGenerator = beanGenerator;
    }

    @Override
    public UserBean loadUserBeanByLogin(String login) {
	UserEntity userEntity = userDao.loadUserByLogin(login);

	return beanGenerator.creatUserBean(userEntity);
    }

    @Override
    public UserBean loadUserBean(Integer userId) {
	UserBean userBean = null;
	UserEntity userEntity = userDao.loadUserById(userId);

	if (userEntity != null) {
	    userBean = beanGenerator.creatUserBean(userEntity);
	}

	return userBean;
    }

    @Override
    public List<UserBean> loadAllUserBean() {
	List<UserEntity> userEntiy = userDao.loadAllUsers();
	List<UserBean> userBean = new ArrayList<>();

	for (UserEntity entity : userEntiy) {
	    UserBean bean = beanGenerator.creatUserBean(entity);
	    userBean.add(bean);
	}

	return userBean;
    }
}