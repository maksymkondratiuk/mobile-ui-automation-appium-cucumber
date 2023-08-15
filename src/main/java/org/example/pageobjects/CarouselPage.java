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

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"carousel\"]")
    public WebElement carousel;
    @AndroidFindBy(xpath = "//*[@text='Native View']")
    public WebElement nativeView;
    @AndroidFindBy(xpath = "//*[@text='Carousel']")
    public WebElement carouselLocator;
    @AndroidFindBy(className = "android.widget.HorizontalScrollView")
    public WebElement scrollView;
    @AndroidFindBy(xpath = "//*[@text='3']")
    public WebElement carouselElement3;
    @AndroidFindBy(xpath = "//*[@text='1']")
    public WebElement carouselElement1;

    public CarouselPage scrollDown(){
        swipeScrollView(0.6, 0.1, 0.5);
        if(isElementDisplayed(nativeView)){
            swipeScrollView(0.6, 0.1, 0.5);
        }
        else if(!isElementDisplayed(carousel)){
            swipeScrollView(0.6, 0.1, 0.5);
        }
        else if(!isElementDisplayed(carouselLocator)){
            swipeScrollView(0.6, 0.1, 0.5);
        }
        return this;
    }

    public CarouselPage openCarousel() {
        carousel.click();
        return this;
    }

    public boolean isCarouselPageDisplayed() {
        return isElementDisplayed(carouselElement1);
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
        return getText(carouselElement3, WaitStrategy.VISIBLE);
    }
}
