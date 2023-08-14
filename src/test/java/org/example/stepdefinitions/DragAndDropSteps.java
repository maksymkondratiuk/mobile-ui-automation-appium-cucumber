package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.pageobjects.DragAndDropPage;
import org.junit.Assert;

public class DragAndDropSteps {
    @Then("User should be in the Drag And Drop page")
    public void userShouldBeOnDragAndDropPage() {
        Assert.assertTrue(new DragAndDropPage().openDragDrop().isDragAndDropPageDisplayed());
    }

    @Then("User perform Drag And Drop and check message")
    public void userPerformDragAndDrop() {
        new DragAndDropPage().dragDropAction();
        Assert.assertEquals("Circle dropped", new DragAndDropPage().getSuccessMessage().trim())
        ;
    }
}
