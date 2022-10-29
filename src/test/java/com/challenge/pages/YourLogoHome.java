package com.challenge.pages;

import com.challenge.utils.AutoTool;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class YourLogoHome {
    @FindBy(xpath = "//a[@class='login']")
    WebElement loginSection;

    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenSection;

    @FindBy(xpath = "//a[@title='Blouses']")
    WebElement blousesSubCategory;

    @FindBy(xpath = "//span[@id='layer_cart_product_price']")
    WebElement productAddedPrice;

    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElement inputSearch;

    @FindBy(xpath = "//button[@name='submit_search']")
    WebElement searchButton;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    WebElement searchMessage;


    public YourLogoHome() {
        PageFactory.initElements(AutoTool.getDriver(), this);
    }

    public void goLoginWebPage() {
        String URL = AutoTool.getSetupValue("URL");
        AutoTool.getDriver().get(URL);
        AutoTool.webHandler().waitForElement(loginSection);
        loginSection.click();
    }

    public void navToSection(String section){
        switch (section.toLowerCase()){
            case "women":
                AutoTool.webHandler().actionMoveToWebElement(womenSection);
                break;
            case "dresses":
                break;
            default:
                break;
        }
    }

    public void goToSubCategory(String category){
        switch (category.toLowerCase()){
            case "blouses":
                blousesSubCategory.click();
                break;
            default:
                break;
        }
    }

    public void printProductAddedPrice(){
        AutoTool.webHandler().waitForElement(productAddedPrice);
        System.out.println("Price of the product: " + productAddedPrice.getText());
    }

    public void searchProduct(String product){
        inputSearch.sendKeys(product);
        searchButton.click();
    }

    public String getSearchMessage(){
        return searchMessage.getText();
    }

}
