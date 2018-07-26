package com.mkren.building;

import com.google.gson.Gson;

public class TestUtil {

    private TestUtil() {
	throw new AssertionError();
    }

    @SuppressWarnings("unchecked")
    public static <T> T makeCopy(T object) {
	Gson gson = new Gson();
	return (T) gson.fromJson(gson.toJson(object), object.getClass());
    }

}
