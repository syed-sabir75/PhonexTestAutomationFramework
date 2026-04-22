package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.codehaus.groovy.runtime.callsite.PogoGetPropertySite;

public class ConfigManagerOLD {
	// I want a programmed to read the Properties file from
	// sre/test/resources/config/config.properties

	private static Properties prop = new Properties();

	private ConfigManagerOLD() {
		// Private Constructor!!!
	}

	static {

		// Operation of loading the properties file in the memory!
		// static block it will be executed! Once During _Class Loading Time!_____

		File configFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "config" + File.separator + "config.properties");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(configFile);
			prop.load(fileReader);

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
