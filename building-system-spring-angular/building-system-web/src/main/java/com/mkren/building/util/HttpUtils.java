package com.mkren.building.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public final class HttpUtils {

	private HttpUtils() {
		throw new AssertionError("Class contains static methods only. You should not instantiate it!");
	}

	public static List<String> getErrorListMessages(BindingResult result) {
		List<String> errorList = new ArrayList<>();
		for (ObjectError error : result.getAllErrors()) {
			errorList.add(error.getDefaultMessage());
		}

		return errorList;

	}
}
