package com.mkren.building.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkren.building.bean.MagazineBean;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class MagazineRestController extends AbstractRestController {

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/magazine-rest", method = RequestMethod.GET)
	public HashMap<String, List> restMagazine() {
		final String surname = "surname";
		final String magazine = "magazine";

		// change to method getAllRecords()
		List<MagazineBean> magazineBeans = magazineService.getRecords(null, null, null);
		List<String> surnameInitials = magazineService.surnameInitials();

		HashMap<String, List> map = new HashMap<>();
		map.put(magazine, magazineBeans);
		map.put(surname, surnameInitials);

		return map;
	}
}