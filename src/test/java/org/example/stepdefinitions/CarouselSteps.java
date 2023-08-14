package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.pageobjects.CarouselPage;
import org.junit.Assert;

public class CarouselSteps {
    @Then("User should be in the Carousel Page")
    public void userShouldBeOnCarouselPage() {
        Assert.assertTrue(new CarouselPage().openCarousel().isCarouselPageDisplayed());
    }

    @Then("User perform Carousel swipe")
    public void userPerformCarouselSwipeTap() {
        new CarouselPage().swipeRightScroll();
        Assert.assertEquals("3", new CarouselPage().getLastBlockNumber().trim());
    }
}
