package com.mkren.building.service.dozer;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;

public class Dozer {

	private static DozerBeanMapper getDoser(String... mappingFileUrls) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(Arrays.asList(mappingFileUrls));
		return mapper;
	}

	public static <T, V> V uneversalConvert(T sourse, Class<V> destClass, Mapping mappingFileUrls) {

		DozerBeanMapper mapper = Dozer.getDoser(mappingFileUrls.getPath());
		V dest = mapper.map(sourse, destClass);

		return dest;
	}

}
