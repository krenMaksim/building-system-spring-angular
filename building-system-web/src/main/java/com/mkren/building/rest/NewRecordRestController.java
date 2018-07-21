package com.mkren.building.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mkren.building.bean.NewRecordBean;
import com.mkren.building.bean.UserBean;
import com.mkren.building.util.HttpUtils;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class NewRecordRestController extends AbstractRestController {

	@PostMapping(value = "/add-new-record-rest", consumes = { "application/json" })
	public List<String> addNewRecord(@Valid @RequestBody NewRecordBean newRecordBean, BindingResult result) {

		if (result.hasErrors()) {
			return HttpUtils.getErrorListMessages(result);
		} else {
			newRecordService.storeNewRecord(newRecordBean);

			List<String> list = new ArrayList<>();
			list.add("New record was added");

			return list;
		}
	}

	@PostMapping(value = "/redaction-record-rest", consumes = { "application/json" })
	public List<String> redactionRecord(@Valid @RequestBody NewRecordBean newRecordBean, BindingResult result) {

		if (result.hasErrors()) {
			return HttpUtils.getErrorListMessages(result);
		} else {
			UserBean author = avtorizationService.loadUserBean(newRecordBean.getAuthorId());
			Integer magazineId = newRecordBean.getId();
			NewRecordBean oldRecordBean = magazineService.getOldRecord(magazineId);

			redactorService.updateRecord(newRecordBean, oldRecordBean, author, magazineId);

			List<String> list = new ArrayList<>();
			list.add("Old record was changed");

			return list;
		}
	}
}