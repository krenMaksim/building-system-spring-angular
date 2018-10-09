package com.mkren.building.service.impl;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

import com.mkren.building.bean.MagazineBean;
import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.dao.MagazineDAO;
import com.mkren.building.dao.SmetaDAO;
import com.mkren.building.dao.UserDAO;
import com.mkren.building.entity.MagazineEntity;
import com.mkren.building.entity.SmetaEntity;
import com.mkren.building.entity.UserEntity;
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
	    return Mockito.mock(UserDAO.class);
	}

	@Bean
	public SmetaDAO smetaDao() {
	    return Mockito.mock(SmetaDAO.class);
	}

    }

    private MagazineService magazineService;
    private MagazineDAO magazineDao;

    @Autowired
    private BeanGenerator beanGenerator;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private SmetaDAO smetaDao;

    private static final MagazineEntity magazineEntity = random(MagazineEntity.class);
    private static final Integer MAGAZINE_ID = magazineEntity.getId();
    private static final Integer FAKE_MAGAZINE_ID = -1;

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

    @Test
    void getOldRecordByFakeMagazineId() {
	when(magazineDao.loadMagazineById(FAKE_MAGAZINE_ID)).thenReturn(null);

	assertEquals(null, magazineService.getOldRecord(FAKE_MAGAZINE_ID));
    }

    @Test
    void getOldRecordByNullMagazineId() {
	when(magazineDao.loadMagazineById(null)).thenThrow(NullPointerException.class);

	assertThrows(NullPointerException.class, () -> {
	    magazineService.getOldRecord(null);
	});
    }

    // test unhappy path later
    @Test
    void getRecords() {
	List<MagazineEntity> listEntity = prepareListEntity();

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

	List<MagazineBean> listBean = listEntity.stream()
	                                        .map(entity -> beanGenerator.createMagazineBean(entity))
	                                        .collect(Collectors.toList());

	assertEquals(listBean, magazineService.getRecords(dateWith, dateOn, surnames));
    }

    @Test
    void surnameInitials() {
	List<MagazineEntity> listEntity = prepareListEntity();

	List<String> surnames = listEntity.stream()
	                                  .map(entity -> entity.getUser()
	                                                       .getSurnameInitials())
	                                  .collect(Collectors.toList());

	assertEquals(surnames, magazineService.surnameInitials());

    }

    private List<MagazineEntity> prepareListEntity() {

	List<MagazineEntity> listEntity = IntStream.range(0, 10)
	                                           .mapToObj(i -> random(MagazineEntity.class))
	                                           .collect(Collectors.toList());
	listEntity.forEach(entity -> {

	    UserEntity user = entity.getUser();
	    when(userDao.loadUserById(user.getId())).thenReturn(user);

	    SmetaEntity smeta = entity.getSmeta();
	    when(smetaDao.loadSmetaById(smeta.getId())).thenReturn(smeta);
	});

	when(magazineDao.loadAllMagazine()).thenReturn(listEntity);

	return listEntity;
    }

    static MagazineEntity generateMagazineEntity() {
	return JsonUtil.makeCopy(magazineEntity);
    }

    NewRecordBean generateNewRecordBean() {
	return beanGenerator.createNewRecordBean(magazineEntity);
    }

}
