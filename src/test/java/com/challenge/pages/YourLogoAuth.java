package com.challenge.pages;

import com.challenge.utils.AutoTool;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourLogoAuth {
    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement loginButton;

    public YourLogoAuth() {
        PageFactory.initElements(AutoTool.getDriver(), this);
    }

    public void doLogin() {
        String user = AutoTool.getSetupValue("email");
        inputEmail.sendKeys(user);
        String pass= AutoTool.getSetupValue("pass");
        inputPassword.sendKeys(pass);
        loginButton.click();
    }
}
