package com.mkren.building.spring;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.mkren.building.dao.mysql")
@EnableTransactionManagement
public class DaoConfig {
	// see /META-INF/persistence.xml
	private static final String PERSISTENCE_UNIT_NAME = "building_system_db";
	private static final String JNDI_RESOURCE_LINK = "java:comp/env/jdbc/building_system_resource";

	@Bean
	DataSource dataSource() {
		DataSource dataSource = null;
		JndiTemplate jndi = new JndiTemplate();
		try {
			dataSource = jndi.lookup(JNDI_RESOURCE_LINK, DataSource.class);
		} catch (NamingException e) {
			throw new RuntimeException("NamingException for java:comp/env/jdbc/...", e);
		}
		return dataSource;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
		// LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
		// emf.setLoadTimeWeaver(loadTimeWeaver);

		return emf;
	}

	@Bean
	public JpaTransactionManager jpaTransMan() {
		JpaTransactionManager jtManager = new JpaTransactionManager(getEntityManagerFactory().getObject());
		return jtManager;
	}

	/*
	 * @Bean(name = "entityManager") public EntityManager getEntityManager() { return getEntityManagerFactory().getObject().createEntityManager(); }
	 */

}

// @Bean
// public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
// return new PersistenceAnnotationBeanPostProcessor();
// }

//// see /META-INF/persistence.xml
// private static final String PERSISTENCE_UNIT_NAME = "building_system_db";
//
// @Bean
// public JpaTransactionManager jpaTransMan() {
// JpaTransactionManager jtManager = new JpaTransactionManager(getEntityManagerFactory().getObject());
// return jtManager;
// }
//
// @Bean
// public LocalEntityManagerFactoryBean getEntityManagerFactory() {
// LocalEntityManagerFactoryBean lemfb = new LocalEntityManagerFactoryBean();
// lemfb.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
// return lemfb;
// }
