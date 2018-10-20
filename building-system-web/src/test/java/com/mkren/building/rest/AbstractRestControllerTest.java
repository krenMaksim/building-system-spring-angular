package com.mkren.building.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mkren.building.rest.AbstractRestControllerTest.RestControllerConfigTest;
import com.mkren.building.service.NewRecordService;
import com.mkren.building.spring.DataSourceConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RestControllerConfigTest.class })
@ActiveProfiles(DataSourceConfig.TEST_PROFILE)
@WebAppConfiguration
abstract class AbstractRestControllerTest {

    @Configuration
    @ImportResource("file:src/main/resources/web-config.xml")
    public static class RestControllerConfigTest {
	@Bean
	public NewRecordService newRecordService() {
	    return Mockito.mock(NewRecordService.class);
	}
    }

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
	DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
	this.mockMvc = builder.build();
    }

}
