package com.mkren.building.service.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {
	public static final String EMPTY_STR = "";
	
	private StringUtils() {
		throw new AssertionError("Class contains static methods only. You should not instantiate it!");
	}

	public static boolean isValidation(String str, String regex) {
		if (str == null) {
			return false;
		}

		Pattern pat = Pattern.compile(regex);
		Matcher mat = pat.matcher(str);
		Boolean validation = mat.matches();
		
		return validation;	
	}
	
	public static boolean isEmpty(String str) {
        if (str != null) {
            return EMPTY_STR.equals(str);
        }

        return true;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
