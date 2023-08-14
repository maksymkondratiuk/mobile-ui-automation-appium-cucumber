package org.example.pageobjects;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;
import org.example.driver.manager.DriverManager;
import org.example.enums.WaitStrategy;
import org.example.pageobjects.screen.ScreenActions;
import org.openqa.selenium.WebElement;

public class LongPressPage extends ScreenActions {
    @AndroidFindBy(id = "android:id/message")
    public WebElement message;
    @AndroidFindBy(xpath = "//*[@text='Long Press']")
    public WebElement longPress;
    @AndroidFindBy(xpath = "//*[@text='Long Press Demo']")
    public WebElement longPressDemo;
    @AndroidFindBy(xpath = "//*[@text='Long Press Me']")
    public WebElement longPressMeButton;

    public LongPressPage openLongPress() {
        longPress.click();
        return this;
    }

    public boolean isLongPressPageDisplayed() {
        return isElementDisplayed(longPressDemo);
    }

    public LongPressPage longPressAction() {
        TouchAction action = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
        action.longPress(ElementOption.element(longPressMeButton)).release().perform();
        return this;
    }

    public String getSuccessMessage() {
        return getText(message, WaitStrategy.VISIBLE);
    }
}
