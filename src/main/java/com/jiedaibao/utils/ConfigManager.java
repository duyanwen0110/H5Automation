package com.jiedaibao.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	public void getConfigManager() throws FileNotFoundException, IOException{
		Properties properties = new Properties();
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("test_config.properties").getPath();
        properties.load(new FileInputStream(path));
	}

}
