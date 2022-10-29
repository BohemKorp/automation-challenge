package com.challenge.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.challenge.utils.AutoTool;

public class ChromeLoader implements DriverLoaderInterface {

	public WebDriver loadDriver() {
		String driverPath = AutoTool.getRunningPath()+"//Drivers//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		if (AutoTool.getSetupValue("driverHeadless").equals("true")) {
			options.addArguments("--headless");
		}
		return new ChromeDriver(options);
	}
}