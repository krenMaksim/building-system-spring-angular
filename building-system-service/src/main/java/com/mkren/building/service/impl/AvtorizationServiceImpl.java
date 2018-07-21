package com.mkren.building.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mkren.building.bean.UserBean;
import com.mkren.building.entity.UserEntity;
import com.mkren.building.service.AvtorizationService;

@Service("avtorizationService")
public class AvtorizationServiceImpl extends AbstractService implements AvtorizationService {

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