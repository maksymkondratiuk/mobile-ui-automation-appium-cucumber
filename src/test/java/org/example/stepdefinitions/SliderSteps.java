package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.pageobjects.SliderPage;
import org.junit.Assert;

public class SliderSteps {

    @Then("User should be in the Slider page")
    public void userShouldBeOnSliderPage() {
        Assert.assertTrue(new SliderPage().openSliderPage().isSliderPageDisplayed());
    }

    @Then("User moving a slider")
    public void userMovingSlider() {
        new SliderPage().moveSlider(0.5);
    }
}
