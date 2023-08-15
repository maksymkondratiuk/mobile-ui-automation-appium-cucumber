package org.example.pageobjects;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.driver.manager.DriverManager;
import org.example.pageobjects.screen.ScreenActions;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SliderPage extends ScreenActions {
    @AndroidFindBy(accessibility = "slider")
    public WebElement slider;
    @AndroidFindBy(xpath = "//*[@text='Slider']")
    public WebElement textSlider;

    public SliderPage openSliderPage() {
        textSlider.click();
        return this;
    }

    public boolean isSliderPageDisplayed() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return isElementDisplayed(slider);
    }


    public SliderPage moveSlider(double index) {
        int start = slider.getLocation().getX();
        int y = slider.getLocation().getY();
        int end = slider.getSize().getWidth();
        TouchAction action = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
        int moveTo = (int)(end*index);
        action.press(point(start,y)).moveTo(point(moveTo, y)).release().perform();
        return this;
    }
}
