package com.ui.pojo;

import java.util.Map;

public class Configuration {
	
	Map<String, Environment> Environment;

	public Map<String, Environment> getEnvironment() {
		return Environment;
	}

	public void setEnvironment(Map<String, Environment> environment) {
		Environment = environment;
	}

}
