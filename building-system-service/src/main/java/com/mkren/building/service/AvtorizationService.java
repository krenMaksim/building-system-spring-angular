package com.mkren.building.service;

import java.util.List;

import com.mkren.building.bean.UserBean;

public interface AvtorizationService {
	public UserBean loadUserBean(Integer userId);

	public UserBean loadUserBeanByLogin(String login);

	public List<UserBean> loadAllUserBean();
}
