package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.pageobjects.NativeViewPage;
import org.junit.Assert;

public class NativeViewSteps {

    @Then("User should be in the Native View page")
    public void userShouldBeOnNativeViewPage() {
        Assert.assertTrue(new NativeViewPage().openNativeView().isNativeViewPageDisplayed());
    }

    @Then("All Views are present")
    public void viewsArePresent() {
        Assert.assertEquals("Hello World, I'm View one", new NativeViewPage().getView1().trim());
        Assert.assertEquals("Hello World, I'm View two", new NativeViewPage().getView2().trim());
        Assert.assertEquals("Hello World, I'm View three", new NativeViewPage().getView3().trim());
    }
}
