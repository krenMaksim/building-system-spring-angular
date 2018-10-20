package com.mkren.building.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mkren.building.bean.MagazineBean;

@CrossOrigin
@RestController
public class MagazineRestController extends AbstractRestController {
    private static final String SURNAME = "surname";
    private static final String MAGAZINE = "magazine";

    @RequestMapping(value = "/magazine-rest", method = RequestMethod.GET)
    public Map<String, List<?>> restMagazine() {

	// change to method getAllRecords()
	List<MagazineBean> magazineBeans = magazineService.getRecords(null, null, null);
	List<String> surnameInitials = magazineService.surnameInitials();

	Map<String, List<?>> map = new HashMap<>();
	map.put(MAGAZINE, magazineBeans);
	map.put(SURNAME, surnameInitials);

	return map;
    }
}