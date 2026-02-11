package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigReader {

	private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
	private static String browserType = null;
	private static Properties prop;

	public static void loadProperties() {
		try (FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties")) {
			prop = new Properties();
			prop.load(fis);

			if (browserType == null || browserType.isEmpty()) {
				setBrowserType(prop.getProperty("browser"));
			}

		} catch (FileNotFoundException e) {
			logger.error("Config file not found: {}", e.getMessage());
			throw new RuntimeException("Config properties file not found.");
		} catch (IOException e) {
			logger.error("Unable to load config properties: {}", e.getMessage());
			throw new RuntimeException("Unable to load config properties.");
		}
	}

	public static String getUsername() {
		return prop.getProperty("userName");
	}

	public static String getPassword() {
		return prop.getProperty("password");
	}

	public static String getUrl() {
		return prop.getProperty("url");
	}

	public static String getTestDataPath()

	{
		return prop.getProperty("test_data_path");
	}

	public static String getSheetName() {
		return prop.getProperty("sheetName");
	}

	public static String getBrowserType() {
		return browserType;
	}

	public static void setBrowserType(String browser) {
		if (browser != null && !browser.isBlank())
			browserType = browser;
	}
}
