package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.pageobjects.LongPressPage;
import org.junit.Assert;

public class LongPressSteps {

    @Then("User should be in the Long Press page")
    public void userShouldBeOnLongPressPage() {
        Assert.assertTrue(new LongPressPage().openLongPress().isLongPressPageDisplayed());
    }

    @Then("User perform Long Press and check message")
    public void userPerformLongPress() {
        new LongPressPage().longPressAction();
        Assert.assertEquals("you pressed me hard :P", new LongPressPage().getSuccessMessage().trim());
        new LongPressPage().clickOkButton();
    }
}
