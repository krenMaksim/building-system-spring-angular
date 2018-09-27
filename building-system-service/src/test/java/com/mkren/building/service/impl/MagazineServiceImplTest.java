package com.mkren.building.service.impl;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.dao.MagazineDAO;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.service.AbstractServiceTest;
import com.mkren.building.service.MagazineService;
import com.mkren.building.service.generator.BeanGenerator;
import com.mkren.building.util.JsonUtil;

class MagazineServiceImplTest extends AbstractServiceTest {

    private MagazineService magazineService;
    private MagazineDAO magazineDao;

    @Autowired
    private BeanGenerator beanGenerator;

    private static final MagazineEntity magazineEntity = random(MagazineEntity.class);
    private static final Integer MAGAZINE_ID = magazineEntity.getId();

    @PostConstruct
    void init() {
	this.magazineDao = Mockito.mock(MagazineDAO.class);
	this.magazineService = new MagazineServiceImpl(this.magazineDao, this.beanGenerator);
    }

    @Test
    void getOldRecord() {
	when(magazineDao.loadMagazineById(MAGAZINE_ID)).thenReturn(generateMagazineEntity());

	assertEquals(generateNewRecordBean(), magazineService.getOldRecord(MAGAZINE_ID));
    }

    static MagazineEntity generateMagazineEntity() {
	return JsonUtil.makeCopy(magazineEntity);
    }

    NewRecordBean generateNewRecordBean() {
	return beanGenerator.createNewRecordBean(magazineEntity);
    }

}
