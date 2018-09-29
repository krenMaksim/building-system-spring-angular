package com.mkren.building.service.dozer;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;

public class Dozer {
    // https://www.java-success.com/dozer-with-spring-maven-tutorial/

    // http://dozer.sourceforge.net/documentation/customconverter.html injecting
    // CustomConverters can also be injected into the DozerBeanMapper if you need to
    // do some manipulation with them before they are used in dozer.
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
