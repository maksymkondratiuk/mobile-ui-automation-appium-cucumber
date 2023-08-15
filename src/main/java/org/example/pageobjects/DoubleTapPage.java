package org.example.pageobjects;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.example.driver.manager.DriverManager;
import org.example.enums.WaitStrategy;
import org.example.pageobjects.screen.ScreenActions;
import org.openqa.selenium.WebElement;

public class DoubleTapPage extends ScreenActions {
    @AndroidFindBy(id = "android:id/message")
    public WebElement message;
    @AndroidFindBy(xpath = "//*[@text='Double Tap']")
    public WebElement doubleTap;
    @AndroidFindBy(xpath = "//*[@text='Double Tap Demo']")
    public WebElement doubleTapDemo;
    @AndroidFindBy(xpath = "//*[@text='Double Tap Me']")
    public WebElement doubleTapMeButton;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement okButton;

    public boolean isDoubleTapPageDisplayed() {
        return isElementDisplayed(doubleTapDemo);
    }

    public DoubleTapPage openDoubleTap() {
        doubleTap.click();
        return this;
    }

    public DoubleTapPage doubleTapAction() {
        TouchAction action = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(doubleTapMeButton))
                .withTapsCount(2)).perform();

        return this;
    }

    public DoubleTapPage clickOkButton() {
        okButton.click();
        return this;
    }

    public String getSuccessMessage() {
        return getText(message, WaitStrategy.VISIBLE);
    }
}
