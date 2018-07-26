package com.mkren.building.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(DataSourceConfig.class)
@ComponentScan("com.mkren.building.dao.mysql")
@EnableTransactionManagement
public class DaoConfig {
    private static final String PERSISTENCE_UNIT_NAME = "building_system_db";

    @Autowired
    private DataSource dataSource;

    @Bean(name = "entityManagerFactory")
    LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
	LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	emf.setDataSource(dataSource);
	emf.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);

	return emf;
    }

    @Bean
    JpaTransactionManager jpaTransMan() {
	JpaTransactionManager jtManager = new JpaTransactionManager(getEntityManagerFactory().getObject());
	return jtManager;
    }
}
