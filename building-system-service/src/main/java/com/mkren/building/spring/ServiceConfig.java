package com.mkren.building.spring;

import java.util.ArrayList;
import java.util.List;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mkren.building.service.converter.MagazineCustomConverter;
import com.mkren.building.service.converter.NewRecordConverter;
import com.mkren.building.service.converter.SmetaCustomConverter;

@Configuration
@Import({ DaoConfig.class, DozerConfig.class })
@ComponentScan({ "com.mkren.building.service.impl", "com.mkren.building.service.generator" })
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

    // @Bean(name = "dozerBean")
    // @Bean
    // public DozerBeanMapperFactoryBean customDozerMapper() throws IOException {
    // DozerBeanMapperFactoryBean mapper = new DozerBeanMapperFactoryBean();
    // Resource[] resources = { new PathMatchingResourcePatternResolver().getResource("classpath*:dozer/dozer_custom_mapping.xml") };
    // mapper.setMappingFiles(resources);
    // return mapper;
    // }

    // @Bean
    // public DozerBeanMapperFactoryBean defaultDozerMapper() throws IOException {
    // DozerBeanMapperFactoryBean mapper = new DozerBeanMapperFactoryBean();
    // Resource[] resources = { new PathMatchingResourcePatternResolver().getResource("classpath*:dozer/dozer_mapping.xml") };
    // mapper.setMappingFiles(resources);
    // return mapper;
    // }

    @Autowired
    private MagazineCustomConverter magazineCustomConverter;

    @Autowired
    private NewRecordConverter newRecordConverter;

    @Autowired
    private SmetaCustomConverter smetaCustomConverter;

    @Bean
    public Mapper customDozerMapper() {
	List<String> mappingFiles = new ArrayList<>();
	mappingFiles.add("dozer/dozer_custom_mapping.xml");

	DozerBeanMapper dozerBeanMapper = new DozerBeanMapper(mappingFiles);

	List<CustomConverter> customConverters = new ArrayList<>();
	customConverters.add(magazineCustomConverter);
	customConverters.add(newRecordConverter);
	customConverters.add(smetaCustomConverter);

	dozerBeanMapper.setCustomConverters(customConverters);

	return dozerBeanMapper;
    }

    // <bean id="org.dozer.Mapper" class="org.dozer.DozerBeanMapper">
    // <property name="mappingFiles">
    // <list>
    // <value>systempropertymapping1.xml</value>
    // <value>dozerBeanMapping.xml</value>
    // <value>injectedCustomConverter.xml</value>
    // </list>
    // </property>
    // <property name="customConverters">
    // <list>
    // <ref bean="customConverterTest"/>
    // </list>
    // </property>
    // </bean>

}
