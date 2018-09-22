package com.mkren.building.spring;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.mkren.building.dao.UserDAO;
import com.mkren.building.service.generator.BeanGenerator;

@Configuration
@Import(DaoConfig.class)
@ComponentScan("com.mkren.building")
public class ServiceConfig {

    @Bean
    @Profile(DataSourceConfig.TEST_PROFILE)
    UserDAO userDao() {
	return Mockito.mock(UserDAO.class);
    }

    @Bean
    @Profile(DataSourceConfig.TEST_PROFILE)
    BeanGenerator beanGenerator() {
	return Mockito.mock(BeanGenerator.class);
    }

}
