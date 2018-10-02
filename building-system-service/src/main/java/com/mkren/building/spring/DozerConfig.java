package com.mkren.building.spring;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
@ComponentScan("com.mkren.building.service.converter")
public class DozerConfig {

    @Bean
    public Mapper defaultDozerMapper() {
	List<String> mappingFiles = new ArrayList<>();
	mappingFiles.add("dozer/dozer_mapping.xml");

	return new DozerBeanMapper(mappingFiles);
    }

}
