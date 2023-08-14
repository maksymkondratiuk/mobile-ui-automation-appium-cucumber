package org.example.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.driver.manager.DriverManager;
import org.example.enums.WaitStrategy;
import org.example.pageobjects.screen.ScreenActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WheelPickerPage extends ScreenActions {
    @AndroidFindBy(xpath = "//*[@text='Wheel Picker']")
    public WebElement wheelPicker;
    @AndroidFindBy(xpath = "//*[@text='Wheel Picker Demo']")
    public WebElement wheelPickerDemo;
    @AndroidFindBy(className = "android.widget.Spinner")
    public WebElement spinner;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Color: black')]")
    public WebElement currentColor;

    public boolean isWheelPickerPageDisplayed() {
        return isElementDisplayed(wheelPicker);
    }

    public WheelPickerPage openWheelPicker(){
        wheelPicker.click();
        return this;
    }

    public WheelPickerPage wheelPickerAction(){
        spinner.click();
        DriverManager.getDriver().findElement(By.xpath("//*[@text='black']")).click();
        return this;
    }

    public String getCurrentColor() {
        return getText(currentColor, WaitStrategy.VISIBLE);
    }
}
