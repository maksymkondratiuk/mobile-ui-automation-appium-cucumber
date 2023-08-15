package org.example.pageobjects.screen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.driver.manager.DriverManager;
import org.example.enums.MobileFindBy;
import org.example.enums.WaitStrategy;
import org.example.factories.WaitFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static org.example.enums.MobileFindBy.*;

public class ScreenActions {

  private final Map<MobileFindBy, Function<String, WebElement>> mobileFindByFunctionMap = new EnumMap(MobileFindBy.class);
  private final Function<String, WebElement> findByXpath =
    mobileElement -> DriverManager.getDriver().findElement(AppiumBy.xpath(mobileElement));
  private final Function<String, WebElement> findByCss =
    mobileElement -> DriverManager.getDriver().findElement(AppiumBy.cssSelector(mobileElement));
  private final Function<String, WebElement> findById =
    mobileElement -> DriverManager.getDriver().findElement(AppiumBy.id(mobileElement));
  private final Function<String, WebElement> findByName =
    mobileElement -> DriverManager.getDriver().findElement(AppiumBy.name(mobileElement));
  private final Function<String, WebElement> findByAccessibilityId =
    mobileElement -> DriverManager.getDriver().findElement(AppiumBy.accessibilityId(mobileElement));
  private final Function<String, WebElement> findByClassName =
    mobileElement -> DriverManager.getDriver().findElement(AppiumBy.className(mobileElement));

  protected ScreenActions() {
    PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
  }

  private WebElement getMobileElement(String mobileElement, MobileFindBy mobileFindBy) {
    if (mobileFindByFunctionMap.isEmpty()) {
      mobileFindByFunctionMap.put(XPATH, findByXpath);
      mobileFindByFunctionMap.put(CSS, findByCss);
      mobileFindByFunctionMap.put(ID, findById);
      mobileFindByFunctionMap.put(NAME, findByName);
      mobileFindByFunctionMap.put(ACCESSIBILITY_ID, findByAccessibilityId);
      mobileFindByFunctionMap.put(CLASS, findByClassName);
    }
    return mobileFindByFunctionMap.get(mobileFindBy).apply(mobileElement);
  }

  public void swipeScrollView(double startPercentage, double endPercentage, double anchorPercentage) {
    Dimension size = DriverManager.getDriver().manage().window().getSize();
    int anchor = (int) (size.width * anchorPercentage);
    int startPoint = (int) (size.height * startPercentage);
    int endPoint = (int) (size.height * endPercentage);
    new TouchAction((PerformsTouchActions) DriverManager.getDriver())
            .press(point(anchor, startPoint))
            .waitAction(waitOptions(ofMillis(1000)))
            .moveTo(point(anchor, endPoint))
            .release().perform();
  }

  protected String getText(WebElement element, WaitStrategy waitStrategy) {
    return WaitFactory.explicitlyWaitForElement(waitStrategy, element).getText();
  }

  protected boolean isElementDisplayed(WebElement element) {
    return element.isDisplayed();
  }

  protected void doClear(WebElement element) {
    element.clear();
  }

  protected void click(WebElement element) {
    element.click();
  }

  protected void click(String element, MobileFindBy elementType) {
    click(getMobileElement(element, elementType));
  }

  protected void enter(WebElement element, String value) {
    WaitFactory.explicitlyWaitForElement(WaitStrategy.VISIBLE, element);
    doClear(element);
    element.sendKeys(value);
  }
}
