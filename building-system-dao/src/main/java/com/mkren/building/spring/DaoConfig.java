package com.mkren.building.spring;

import java.nio.charset.StandardCharsets;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
@ComponentScan("com.mkren.building.dao.mysql")
@EnableTransactionManagement
public class DaoConfig {
    private static final String PERSISTENCE_UNIT_NAME = "building_system_db";
    @SuppressWarnings("unused")
    private static final String JNDI_RESOURCE_LINK = "java:comp/env/jdbc/building_system_resource";

    // @Bean
    // DataSource dataSource() {
    // DataSource dataSource = null;
    // JndiTemplate jndi = new JndiTemplate();
    // try {
    // dataSource = jndi.lookup(JNDI_RESOURCE_LINK, DataSource.class);
    // } catch (NamingException e) {
    // throw new RuntimeException("NamingException for java:comp/env/jdbc/...", e);
    // }
    // return dataSource;
    // }

    @Bean
    public DataSource dataSource() {
	MysqlDataSource dataSource = new MysqlDataSource();

	dataSource.setServerName("localhost");
	dataSource.setPortNumber(3306);
	dataSource.setDatabaseName("building_system");
	dataSource.setUser("root");
	dataSource.setPassword("root");
	dataSource.setCharacterEncoding(StandardCharsets.UTF_8.name());
	return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
	LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	emf.setDataSource(dataSource());
	emf.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);

	return emf;
    }

    @Bean
    public JpaTransactionManager jpaTransMan() {
	JpaTransactionManager jtManager = new JpaTransactionManager(getEntityManagerFactory().getObject());
	return jtManager;
    }
}
