package com.challenge.webDriver;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

	public static WebDriver createDriver(String driverType) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("chrome", "com.challenge.webDriver.ChromeLoader");

		try {
			@SuppressWarnings("unchecked")
			Class<DriverLoaderInterface> tClass = (Class<DriverLoaderInterface>)Class.forName(map.get((driverType.toLowerCase())));
			DriverLoaderInterface driverLoader = tClass.getDeclaredConstructor().newInstance();

			return driverLoader.loadDriver();
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		return null;
	}
}