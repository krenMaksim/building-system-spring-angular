package com.mkren.building.service.impl;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.dao.MagazineDAO;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.service.MagazineService;
import com.mkren.building.service.generator.BeanGenerator;
import com.mkren.building.util.JsonUtil;

class MagazineServiceImplTest extends AbstractService {

    private final MagazineService magazineService;

    private final MagazineDAO magazineDao;

    @Autowired
    private BeanGenerator beanGenerator;

    private static final MagazineEntity magazineEntity = random(MagazineEntity.class);

    private static final Integer MAGAZINE_ID = magazineEntity.getId();

    MagazineServiceImplTest() {
	this.magazineDao = Mockito.mock(MagazineDAO.class);
	this.magazineService = new MagazineServiceImpl(this.magazineDao, this.beanGenerator);
    }

    @Test
    void getOldRecord() {
	when(magazineDao.loadMagazineById(MAGAZINE_ID)).thenReturn(generateMagazineEntity());
	// when(beanGenerator.createNewRecordBean(generateMagazineEntity())).thenReturn(generateNewRecordBean());
	//
	assertEquals(generateNewRecordBean(), magazineService.getOldRecord(MAGAZINE_ID));
    }

    static MagazineEntity generateMagazineEntity() {
	return JsonUtil.makeCopy(magazineEntity);
    }

    NewRecordBean generateNewRecordBean() {
	return beanGenerator.createNewRecordBean(magazineEntity);
    }

    // static NewRecordBean generateNewRecordBean() {
    // NewRecordBean newRecordBean = new NewRecordBean();
    //
    // newRecordBean.setId(userEntity.getId());
    // newRecordBean.setLogin(userEntity.getLogin());
    // newRecordBean.setPassword(userEntity.getPassword());
    // newRecordBean.setSurnameInitials(userEntity.getSurnameInitials());
    // newRecordBean.setRole(userEntity.getRole());
    //
    // return newRecordBean;
    // }

}
