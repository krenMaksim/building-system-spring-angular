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

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkren.building.bean.SmetaBean;
import com.mkren.building.service.NewRecordService;
import com.mkren.building.util.JsonUtil;

class SmetaRestControllerTest extends AbstractRestControllerTest {

    @Autowired
    private NewRecordService newRecordService;

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
