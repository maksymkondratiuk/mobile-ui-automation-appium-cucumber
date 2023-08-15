package org.example.pageobjects;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;
import org.example.driver.manager.DriverManager;
import org.example.enums.WaitStrategy;
import org.example.pageobjects.screen.ScreenActions;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DragAndDropPage extends ScreenActions {
    @AndroidFindBy(accessibility = "success")
    public WebElement message;
    @AndroidFindBy(xpath = "//*[@text='Drag & Drop']")
    public WebElement dragDrop;
    @AndroidFindBy(xpath = "//*[@text='Drag me!']")
    public WebElement dragMeButton;
    @AndroidFindBy(xpath = "//*[@text='Drop here.']")
    public WebElement dropHere;

    public DragAndDropPage openDragDrop() {
        dragDrop.click();
        return this;
    }

    public boolean isDragAndDropPageDisplayed() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return isElementDisplayed(dragMeButton);
    }

    public DragAndDropPage dragDropAction() {
        TouchAction action = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
        action.longPress(ElementOption.element(dragMeButton)).moveTo(ElementOption.element(dropHere)).release().perform();

        return this;
    }

    public String getSuccessMessage() {
        return getText(message, WaitStrategy.VISIBLE);
    }
}
