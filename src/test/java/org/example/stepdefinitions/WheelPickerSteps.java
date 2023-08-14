package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.pageobjects.WheelPickerPage;
import org.example.pageobjects.screen.ScreenActions;
import org.junit.Assert;

public class WheelPickerSteps extends ScreenActions {

    @Then("User should be in the WheelPicker Page")
    public void userShouldBeOnWheelPickerPage() {
        Assert.assertTrue(new WheelPickerPage().openWheelPicker().isWheelPickerPageDisplayed());
    }

    @Then("User perform WheelPicker color change")
    public void userPerformWheelPickerColorChange() {
        new WheelPickerPage().wheelPickerAction();
        Assert.assertEquals("Current Color: black", new WheelPickerPage().getCurrentColor().trim());
    }
}
