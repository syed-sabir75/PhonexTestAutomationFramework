package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.codehaus.groovy.runtime.callsite.PogoGetPropertySite;

public class ConfigManager {
	// I want a programmed to read the Properties file from
	// sre/test/resources/config/config.properties

	private static Properties prop = new Properties();
	private static String path = "config/config.properties";
	private static String env;

	private ConfigManager() {
		// Private Constructor!!!
	}

	static {

		env = System.getProperty("env", "qa");
		env = env.toLowerCase().trim();
		System.out.println("Running Tests in Env" + env);
		switch (env) {
		case "dev" -> path = "config/config.dev.properties";

		case "qa" -> path = "config/config.qa.properties";

		case "uat" -> path = "config/config.uat.properties";

		default -> path = "config/config.qa.properties";
		}

		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

		if (input == null) {
			throw new RuntimeException("Cannot find the file at the path" + path);
		}

		try {
			prop.load(input);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getProperty(String key) {

		return prop.getProperty(key);

	}

}
