package com.mkren.building.service.impl;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

import com.mkren.building.bean.SmetaBean;
import com.mkren.building.dao.MagazineDAO;
import com.mkren.building.dao.SmetaDAO;
import com.mkren.building.entity.SmetaEntity;
import com.mkren.building.service.NewRecordService;
import com.mkren.building.service.generator.BeanGenerator;
import com.mkren.building.service.impl.NewRecordServiceImplTest.NewRecordConfig;
import com.mkren.building.spring.DataSourceConfig;
import com.mkren.building.spring.ServiceConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { NewRecordConfig.class })
@ActiveProfiles(DataSourceConfig.TEST_PROFILE)
class NewRecordServiceImplTest {

    @Configuration
    @Import(ServiceConfig.class)
    public static class NewRecordConfig {

	@Bean
	public MagazineDAO magazineDao() {
	    return Mockito.mock(MagazineDAO.class);
	}

	@Bean
	public SmetaDAO smetaDao() {
	    return Mockito.mock(SmetaDAO.class);
	}

    }

    @Autowired
    private NewRecordService newRecordService;

    @Autowired
    private SmetaDAO smetaDao;

    @Autowired
    private MagazineDAO magazineDao;

    @Autowired
    private BeanGenerator beanGenerator;

    @Test
    void getAllSmeta() {
	List<SmetaEntity> listEntity = IntStream.range(0, 10)
	                                        .mapToObj(i -> random(SmetaEntity.class))
	                                        .collect(Collectors.toList());

	List<SmetaBean> listBean = listEntity.stream()
	                                     .map(entity -> beanGenerator.createSmetaBean(entity))
	                                     .collect(Collectors.toList());

	when(smetaDao.loadAllSmeta()).thenReturn(listEntity);

	assertEquals(listBean, newRecordService.getAllSmeta());
    }

    // @Test
    // void storeNewRecord() {
    // }

    @Test
    void storeNewRecordNullValue() {
	when(magazineDao.storeMagazine(null)).thenThrow(NullPointerException.class);

	assertThrows(NullPointerException.class, () -> {
	    newRecordService.storeNewRecord(null);
	});
    }

}
