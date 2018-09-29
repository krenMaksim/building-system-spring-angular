package com.mkren.building.spring;

import java.io.IOException;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@Import(DaoConfig.class)
@ComponentScan("com.mkren.building")
public class ServiceConfig {

    // @Bean
    // @Profile(DataSourceConfig.TEST_PROFILE)
    // UserDAO userDao() {
    // return Mockito.mock(UserDAO.class);
    // }
    //
    // @Bean
    // @Profile(DataSourceConfig.TEST_PROFILE)
    // BeanGenerator beanGenerator() {
    // return Mockito.mock(BeanGenerator.class);
    // }

    @Bean(name = "dozerBean")
    public DozerBeanMapperFactoryBean configDozer() throws IOException {
	DozerBeanMapperFactoryBean mapper = new DozerBeanMapperFactoryBean();
	// Resource[] resources = new
	// PathMatchingResourcePatternResolver().getResources("classpath*:dozer-bean-mappings.xml");
	Resource[] resources = { new PathMatchingResourcePatternResolver().getResource("classpath*:dozer/dozer_mapping.xml"), new PathMatchingResourcePatternResolver().getResource("classpath*:dozer/dozer_custom_mapping.xml") };
	mapper.setMappingFiles(resources);
	return mapper;
    }

}
