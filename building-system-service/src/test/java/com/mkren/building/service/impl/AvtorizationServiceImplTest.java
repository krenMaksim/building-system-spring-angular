package com.mkren.building.service.impl;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkren.building.bean.UserBean;
import com.mkren.building.dao.UserDAO;
import com.mkren.building.entity.UserEntity;
import com.mkren.building.service.AbstractServiceTest;
import com.mkren.building.service.AvtorizationService;
import com.mkren.building.service.generator.BeanGenerator;
import com.mkren.building.util.JsonUtil;

class AvtorizationServiceImplTest extends AbstractServiceTest {

    @Autowired
    private AvtorizationService avtorizationService;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private BeanGenerator beanGenerator;

    private static final UserEntity userEntity = random(UserEntity.class);
    private static String userLogin = userEntity.getLogin();
    private static Integer userId = userEntity.getId();

    @Test
    void loadUserBeanByLogin() {
	when(userDao.loadUserByLogin(userLogin)).thenReturn(generateUserEntity());
	when(beanGenerator.creatUserBean(generateUserEntity())).thenReturn(generateUserBean());

	assertEquals(generateUserBean(), avtorizationService.loadUserBeanByLogin(userLogin));
    }

    @Test
    void loadUserBeanByNullLogin() {
	when(userDao.loadUserByLogin(null)).thenThrow(NullPointerException.class);

	assertThrows(NullPointerException.class, () -> {
	    avtorizationService.loadUserBeanByLogin(null);
	});
    }

    @Test
    void loadUserBeanByFakeLogin() {
	String fakeLogin = random(String.class);

	when(userDao.loadUserByLogin(fakeLogin)).thenReturn(null);
	when(beanGenerator.creatUserBean(null)).thenReturn(null);

	assertEquals(null, avtorizationService.loadUserBeanByLogin(fakeLogin));
    }

    @Test
    void loadUserBean() {
	when(userDao.loadUserById(userId)).thenReturn(generateUserEntity());
	when(beanGenerator.creatUserBean(generateUserEntity())).thenReturn(generateUserBean());

	assertEquals(generateUserBean(), avtorizationService.loadUserBean(userId));
    }

    @Test
    void loadBeanByNullId() {
	when(userDao.loadUserById(null)).thenThrow(NullPointerException.class);

	assertThrows(NullPointerException.class, () -> {
	    avtorizationService.loadUserBean(null);
	});
    }

    @Test
    void loadUserBeanByFakeId() {
	Integer fakeId = random(Integer.class);

	when(userDao.loadUserById(fakeId)).thenReturn(null);
	when(beanGenerator.creatUserBean(null)).thenReturn(null);

	assertEquals(null, avtorizationService.loadUserBean(fakeId));
    }

    @Test
    void loadAllUserBean() {
	int listSize = 10;
	List<UserEntity> userEntiyList = Collections.nCopies(listSize, generateUserEntity());
	List<UserBean> userBeanList = Collections.nCopies(listSize, generateUserBean());

	when(userDao.loadAllUsers()).thenReturn(userEntiyList);
	when(beanGenerator.creatUserBean(generateUserEntity())).thenReturn(generateUserBean());

	assertEquals(userBeanList, avtorizationService.loadAllUserBean());
    }

    static UserEntity generateUserEntity() {
	return JsonUtil.makeCopy(userEntity);
    }

    static UserBean generateUserBean() {
	UserBean userBean = new UserBean();

	userBean.setId(userEntity.getId());
	userBean.setLogin(userEntity.getLogin());
	userBean.setPassword(userEntity.getPassword());
	userBean.setSurnameInitials(userEntity.getSurnameInitials());
	userBean.setRole(userEntity.getRole());

	return userBean;
    }

}
