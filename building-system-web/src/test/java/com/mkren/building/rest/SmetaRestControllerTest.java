package com.mkren.building.rest;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

import com.mkren.building.bean.SmetaBean;
import com.mkren.building.rest.SmetaRestControllerTest.SmetaRestControllerConfig;
import com.mkren.building.service.NewRecordService;
import com.mkren.building.spring.DataSourceConfig;
import com.mkren.building.util.JsonUtil;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SmetaRestControllerConfig.class })
@ActiveProfiles(DataSourceConfig.TEST_PROFILE)
@WebAppConfiguration
class SmetaRestControllerTest {

    @Configuration
    @ImportResource("file:src/main/resources/web-config.xml")
    public static class SmetaRestControllerConfig {
	@Bean
	public NewRecordService newRecordService() {
	    return Mockito.mock(NewRecordService.class);
	}
    }

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private NewRecordService newRecordService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
	DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
	this.mockMvc = builder.build();
    }

    @Test
    void restSmeta() throws Exception {
	List<SmetaBean> listBeans = IntStream.range(0, 10)
	                                     .mapToObj(i -> random(SmetaBean.class))
	                                     .collect(Collectors.toList());

	when(newRecordService.getAllSmeta()).thenReturn(listBeans);

	mockMvc.perform(get("/smeta-rest"))
	       .andDo(print())
	       .andExpect(status().isOk())
	       .andExpect(content().json(JsonUtil.toJson(listBeans)));
    }
}
