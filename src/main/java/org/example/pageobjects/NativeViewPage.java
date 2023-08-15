package org.example.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.enums.WaitStrategy;
import org.example.pageobjects.screen.ScreenActions;
import org.openqa.selenium.WebElement;

public class NativeViewPage extends ScreenActions {

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"textView\"])[1]")
    public WebElement itemViewOne;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"textView\"])[2]")
    public WebElement itemViewTwo;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"textView\"])[3]")
    public WebElement itemViewThree;

    @AndroidFindBy(xpath = "//*[@text='Native View']")
    public WebElement nativeView;

    public NativeViewPage openNativeView() {
        nativeView.click();
        return this;
    }

    public boolean isNativeViewPageDisplayed() {
        return isElementDisplayed(itemViewOne);
    }

    public String getView1() {
        return getText(itemViewOne, WaitStrategy.VISIBLE);
    }

    public String getView2() {
        return getText(itemViewTwo, WaitStrategy.VISIBLE);
    }

    public String getView3() {
        return getText(itemViewThree, WaitStrategy.VISIBLE);
    }

}
