package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.pageobjects.VerticalSwipePage;
import org.junit.Assert;

public class VerticalSwipeSteps {
    @Then("User should be in the Vertical Swipe page")
    public void userShouldBeOnVerticalSwipePage() {
        Assert.assertTrue(new VerticalSwipePage().openVerticalSwipePage().isVerticalSwipePageDisplayed());
    }

    @Then("User perform vertical swipe")
    public void userPerformVerticalSwipe() {
        new VerticalSwipePage().swipeScrollView(0.5, 0.2);
    }
}
