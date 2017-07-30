package com.mkren.building.service.util;

import java.util.List;

public final class MagazineUtils {
	private MagazineUtils() {
		throw new AssertionError("Class contains static methods only. You should not instantiate it!");
	}

	public static boolean surnameIsConsist(String name, List<String> listNames) {
		if (name == null) {
			return false;
		}
		if (listNames == null) {
			return true;
		}
		if (listNames.isEmpty()) {
			return true;
		}

		return listNames.contains(name);
	}
}
