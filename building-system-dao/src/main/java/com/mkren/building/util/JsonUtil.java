package com.mkren.building.util;

import com.google.gson.Gson;

public class JsonUtil {

    private JsonUtil() {
	throw new AssertionError();
    }

    @SuppressWarnings("unchecked")
    public static <T> T makeCopy(T object) {
	Gson gson = new Gson();
	return (T) gson.fromJson(gson.toJson(object), object.getClass());
    }

    public static <T> String toJson(T object) {
	return new Gson().toJson(object);
    }

}
