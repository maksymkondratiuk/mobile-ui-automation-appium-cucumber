package org.example.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.driver.manager.DriverManager;
import org.example.pageobjects.screen.ScreenActions;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class VerticalSwipePage extends ScreenActions {
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"listview\"]/android.view.ViewGroup")
    public WebElement listView;
    @AndroidFindBy(xpath = "//*[@text='Vertical swiping']")
    public WebElement swipe;

    public VerticalSwipePage openVerticalSwipePage() {
        swipe.click();
        return this;
    }

    public boolean isVerticalSwipePageDisplayed() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return isElementDisplayed(listView);
    }

    public VerticalSwipePage swipeOnThePage(){
        swipeScrollView(0.8, 0.2, 0.5);
        return this;
    }
}
