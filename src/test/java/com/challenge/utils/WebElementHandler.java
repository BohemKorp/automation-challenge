package com.challenge.utils;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public final class WebElementHandler {
	private static WebElementHandler instance = new WebElementHandler();
	private ThreadLocal <Wait<WebDriver>> fluentWaitThreadHolder = new ThreadLocal<Wait<WebDriver>>();
	private final int implicitWaitTimeOut = Integer.valueOf(AutoTool.getSetupValue("implicitWaitTimeOutSeconds"));
	private final int fluentWaitTimeOut = Integer.valueOf(AutoTool.getSetupValue("fluentWaitTimeoutSeconds"));
	private final int fleuntWaitPollingInterval = Integer.valueOf(AutoTool.getSetupValue("fluentWaitPollingEveryMillis"));
		
    private WebElementHandler() {
    }

    public static WebElementHandler getInstance() {
        return instance;
    }
    

	protected void setThreadWaitObjects() {
		AutoTool.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTimeOut));
		setFluentWait(fluentWaitTimeOut, fleuntWaitPollingInterval);
	}
	

	protected void setFluentWait(int timeOut, int pollingInterval) {
		fluentWaitThreadHolder.set(new FluentWait<WebDriver>(AutoTool.getDriver())
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingInterval))
				.ignoring(NoSuchElementException.class));
	}
	

	protected void removeThreadWaitObjects() {
		fluentWaitThreadHolder.remove();
	}
	

	public Wait<WebDriver> getFluentWait() {
		return fluentWaitThreadHolder.get();
	}
	

	public void waitForElement(WebElement webElement) {
		getFluentWait().until(ExpectedConditions.visibilityOf(webElement));
	}

	public void actionMoveToWebElement(WebElement webElement){
		Actions action = new Actions(AutoTool.getDriver());
		action.moveToElement(webElement).perform();
	}
}