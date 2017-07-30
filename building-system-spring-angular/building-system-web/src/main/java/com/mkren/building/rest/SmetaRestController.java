package com.mkren.building.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkren.building.bean.SmetaBean;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class SmetaRestController extends AbstractRestController {

	@RequestMapping(value = "/smeta-rest", method = RequestMethod.GET)
	public List<SmetaBean> restSmeta() {
		List<SmetaBean> smetaBeans = newRecordService.getAllSmeta();

		return smetaBeans;
	}
}