package com.challenge.steps;

import com.challenge.utils.AutoTool;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CatalogSteps {
    @When("I add the first garment to the cart")
    public void iAddTheFirstGarmentToTheCart() {
        AutoTool.pageObject().yourLogoCatalog().selectFirstProduct();
        AutoTool.addScreenshotToCucumberExecutionReport("product_added_ss");
    }

    @Then("I print the value of the garment")
    public void iPrintTheValueOfTheGarment() {
        AutoTool.pageObject().yourLogoHome().printProductAddedPrice();
        AutoTool.addScreenshotToCucumberExecutionReport("cart_modal_ss");
    }
}
