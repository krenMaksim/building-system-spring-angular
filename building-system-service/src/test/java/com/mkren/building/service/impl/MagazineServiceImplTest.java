package com.mkren.building.service.impl;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.dao.MagazineDAO;
import com.mkren.building.dao.UserDAO;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.service.MagazineService;
import com.mkren.building.service.generator.BeanGenerator;
import com.mkren.building.service.impl.MagazineServiceImplTest.MagazineConfig;
import com.mkren.building.spring.DataSourceConfig;
import com.mkren.building.spring.ServiceConfig;
import com.mkren.building.util.JsonUtil;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { MagazineConfig.class })
@ActiveProfiles(DataSourceConfig.TEST_PROFILE)
class MagazineServiceImplTest {

    @Configuration
    @Import(ServiceConfig.class)
    public static class MagazineConfig {

	@Bean
	public UserDAO userDao() {

	    UserDAO userDao = Mockito.mock(UserDAO.class);

	    return Mockito.mock(UserDAO.class);
	}
    }

    private MagazineService magazineService;
    private MagazineDAO magazineDao;

    @Autowired
    private BeanGenerator beanGenerator;

    @Autowired
    private UserDAO userDao;

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

    // @Test
    void getRecords() {
	List<MagazineEntity> listEntity = IntStream.range(0, 10)
	                                           .mapToObj(i -> random(MagazineEntity.class))
	                                           .collect(Collectors.toList());

	Date dateWith = listEntity.stream()
	                          .min(Comparator.comparing(MagazineEntity::getDate))
	                          .get()
	                          .getDate();

	Date dateOn = listEntity.stream()
	                        .max(Comparator.comparing(MagazineEntity::getDate))
	                        .get()
	                        .getDate();

	List<String> surnames = listEntity.stream()
	                                  .map(entity -> entity.getUser()
	                                                       .getSurnameInitials())
	                                  .collect(Collectors.toList());

	listEntity.stream()
	          .map(entity -> entity.getUser())
	          .forEach(user -> when(userDao.loadUserById(user.getId())).thenReturn(user));

	when(magazineDao.loadAllMagazine()).thenReturn(listEntity);

	assertEquals(listEntity, magazineService.getRecords(dateWith, dateOn, surnames));

    }

    static MagazineEntity generateMagazineEntity() {
	return JsonUtil.makeCopy(magazineEntity);
    }

    NewRecordBean generateNewRecordBean() {
	return beanGenerator.createNewRecordBean(magazineEntity);
    }

}
