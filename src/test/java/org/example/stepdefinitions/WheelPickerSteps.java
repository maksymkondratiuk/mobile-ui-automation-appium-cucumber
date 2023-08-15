package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.pageobjects.WheelPickerPage;
import org.example.pageobjects.screen.ScreenActions;
import org.junit.Assert;

public class WheelPickerSteps extends ScreenActions {

    @Then("User scrolling to the WheelPicker Page")
    public void userScrollingToWheelPickerPage() {
        new WheelPickerPage().scrollDowntoTab();
    }

    @Then("User should be in the WheelPicker Page")
    public void userShouldBeOnWheelPickerPage() {
        new WheelPickerPage().scrollDowntoTab();
        Assert.assertTrue(new WheelPickerPage().openWheelPicker().isWheelPickerPageDisplayed());
    }

    @Then("User perform WheelPicker color change")
    public void userPerformWheelPickerColorChange() {
        new WheelPickerPage().wheelPickerAction();
        Assert.assertEquals("Current Color: black", new WheelPickerPage().getCurrentColor().trim());
    }
}
