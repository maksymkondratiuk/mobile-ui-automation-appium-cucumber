package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.pageobjects.DoubleTapPage;
import org.junit.Assert;

public class DoubleTapSteps {

    @Then("User should be in the Double Tap page")
    public void userShouldBeOnDoubleTapPage() {
        Assert.assertTrue(new DoubleTapPage().openDoubleTap().isDoubleTapPageDisplayed());
    }

    @Then("User perform Double Tap and check message")
    public void userPerformDoubleTap() {
        new DoubleTapPage().doubleTapAction();
        Assert.assertEquals("Double tap successful!", new DoubleTapPage().getSuccessMessage().trim());
        new DoubleTapPage().clickOkButton();
    }
}
