package com.mkren.building.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mkren.building.spring.ServiceConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class })
// @ActiveProfiles(DataSourceConfig.TEST_PROFILE)
public abstract class AbstractServiceTest {

}
