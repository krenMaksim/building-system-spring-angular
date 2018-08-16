package com.mkren.building.spring;

import java.nio.charset.StandardCharsets;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

//@Configuration
public class DataSourceConfig {
    public static final String TEST_PROFILE = "test";

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

    @Bean("dataSource")
    @Profile("default")
    DataSource dataSource() {
	MysqlDataSource dataSource = new MysqlDataSource();

	dataSource.setServerName("localhost");
	dataSource.setPortNumber(3306);
	dataSource.setDatabaseName("building_system");
	dataSource.setUser("root");
	dataSource.setPassword("root");
	dataSource.setCharacterEncoding(StandardCharsets.UTF_8.name());
	return dataSource;
    }

    // @Bean("dataSource")
    // @Profile(TEST_PROFILE)
    // DataSource dataSourceTest() {
    // MysqlDataSource dataSource = (MysqlDataSource) dataSource();
    // dataSource.setDatabaseName("building_system_test");
    // return dataSource;
    // }

    @Bean("dataSource")
    @Profile(TEST_PROFILE)
    DataSource dataSourceTest() {
	return new EmbeddedDatabaseBuilder().generateUniqueName(true)
	                                    .setType(EmbeddedDatabaseType.H2)
	                                    .setScriptEncoding(StandardCharsets.UTF_8.name())
	                                    .ignoreFailedDrops(true)
	                                    .addScript("building_system_test_h2.sql")
	                                    .build();
    }
}
