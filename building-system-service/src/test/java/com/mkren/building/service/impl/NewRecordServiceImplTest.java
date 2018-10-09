package com.mkren.building.service.impl;

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

import com.mkren.building.dao.MagazineDAO;
import com.mkren.building.dao.SmetaDAO;
import com.mkren.building.service.NewRecordService;
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

    @Test
    void getAllSmeta() {
    }

}
