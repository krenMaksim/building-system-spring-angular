package com.mkren.building.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkren.building.bean.SmetaBean;
import com.mkren.building.service.NewRecordService;

@CrossOrigin
@RestController
public class SmetaRestController {

    @Autowired
    private NewRecordService newRecordService;

    @GetMapping("/smeta-rest")
    public List<SmetaBean> restSmeta() {
	return newRecordService.getAllSmeta();
    }
}