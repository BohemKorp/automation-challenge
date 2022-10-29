package com.challenge.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.challenge.webDriver.DriverFactory;

public final class AutoTool {
	private static ThreadLocal <WebDriver> webDriverThreadHolder = new ThreadLocal <WebDriver>();
	private static String appLocation = System.getProperty("user.dir").replace("\\", "//");
	private static Properties properties=null;

	public static String getRunningPath() {
		return appLocation;
	}

	public synchronized static void setupDriver(String selectedDriver) {
		webDriverThreadHolder.set(DriverFactory.createDriver(selectedDriver));
		webHandler().setThreadWaitObjects();
		pageObject().setThreadPagesContainer();
	}
	

	public static void clearDriver() {
		if (getDriver()!=null) {
			webDriverThreadHolder.get().close();
			webDriverThreadHolder.get().quit();
			webDriverThreadHolder.remove();
			webHandler().removeThreadWaitObjects();
			pageObject().removeThreadPagesContainer();
		}
	}

	public static WebDriver getDriver() {
		return webDriverThreadHolder.get();
	}

	public static void loadSetupValues() {
		try {
			InputStream configFileInput = new FileInputStream("src/test/resources/config.properties");
			properties = new Properties();
			properties.load(configFileInput);
			configFileInput.close();
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}

	public static String getSetupValue(String value) {
		return properties.getProperty(value);
	}


	public static void addScreenshotToCucumberExecutionReport(String imageFileName) {
		final byte[] screenshot = ((TakesScreenshot)AutoTool.getDriver()).getScreenshotAs(OutputType.BYTES);
		AutoTool.scenarioHandler().getScenario().attach(screenshot, "image/png", imageFileName);
	}

	public static ScenarioHandler scenarioHandler() {
		return ScenarioHandler.getInstance();
	}

	public static WebElementHandler webHandler() {
		return WebElementHandler.getInstance();
	}

	public static PageObjectHandler pageObject() {
		return PageObjectHandler.getInstance();
	}

}