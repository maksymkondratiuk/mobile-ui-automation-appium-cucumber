package org.example.pageobjects;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.driver.manager.DriverManager;
import org.example.enums.WaitStrategy;
import org.example.pageobjects.screen.ScreenActions;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.offset.PointOption.point;

public class CarouselPage extends ScreenActions {

    @AndroidFindBy(xpath = "//*[@text='Carousel']")
    public WebElement carousel;
    @AndroidFindBy(xpath = "//*[@text='Carousel - Swipe left/right']")
    public WebElement carouselSwipe;
    @AndroidFindBy(className = "android.widget.HorizontalScrollView")
    public WebElement scrollView;
    @AndroidFindBy(xpath = "//*[@text='3']")
    public WebElement carouselElement;

    public CarouselPage openCarousel() {
        carousel.click();
        return this;
    }

    public boolean isCarouselPageDisplayed() {
        return isElementDisplayed(carousel);
    }

    public CarouselPage swipeRightScroll() {
        int startX = (int) (scrollView.getSize().width * 0.90);
        int endX = (int) (scrollView.getSize().width * 0.10);
        int startY = scrollView.getSize().height / 2;
        TouchAction action = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
        action.press(point(startX,startY)).moveTo(point(endX, startY)).release().perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getLastBlockNumber() {
        return getText(carouselElement, WaitStrategy.VISIBLE);
    }
}
