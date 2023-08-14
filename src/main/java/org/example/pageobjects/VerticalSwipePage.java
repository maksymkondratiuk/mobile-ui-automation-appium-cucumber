package org.example.pageobjects;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.driver.manager.DriverManager;
import org.example.pageobjects.screen.ScreenActions;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.offset.PointOption.point;

public class VerticalSwipePage extends ScreenActions {
    @AndroidFindBy(id = "listview")
    public WebElement listView;
    @AndroidFindBy(xpath = "//*[@text='Vertical swiping']")
    public WebElement swipe;

    public VerticalSwipePage openVerticalSwipePage() {
        swipe.click();
        return this;
    }

    public boolean isVerticalSwipePageDisplayed() {
        return isElementDisplayed(swipe);
    }

    public VerticalSwipePage swipeScrollView(double indexStart, double indexY) {
        int height = listView.getSize().getHeight();
        int width = listView.getSize().getWidth();
        int startX = width/2;
        int startY = (int) (height * indexStart);
        int endY = (int) (height * indexY);
        TouchAction action = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
        action.press(point(startX,startY)).moveTo(point(startX, endY)).release().perform();
        return this;
    }
}
