package com.mkren.building.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
@ComponentScan("com.mkren.building")
public class ServiceConfig {

}
