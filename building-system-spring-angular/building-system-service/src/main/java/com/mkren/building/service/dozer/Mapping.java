package com.mkren.building.service.dozer;

public enum Mapping {
	DEFAULT("dozer/dozer_mapping.xml"),
	CUSTOM("dozer/dozer_custom_mapping.xml");
	
	private String path;
	
	private Mapping(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
}
