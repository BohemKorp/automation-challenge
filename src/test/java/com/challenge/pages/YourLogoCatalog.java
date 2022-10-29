package com.challenge.pages;

import com.challenge.utils.AutoTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourLogoCatalog {

    @FindBy(xpath = "//div[@class='product-container']")
    List<WebElement> productList;

    public YourLogoCatalog() {
        PageFactory.initElements(AutoTool.getDriver(), this);
    }

    public void selectFirstProduct(){
        AutoTool.webHandler().actionMoveToWebElement(productList.get(0));
        addToCart(productList.get(0));
    }

    private void addToCart(WebElement webElement){
        WebElement addButton = webElement.findElement(By.xpath("//a[@title='Add to cart']"));
        addButton.click();
    }
}
