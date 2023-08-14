package org.example.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.enums.WaitStrategy;
import org.example.pageobjects.screen.ScreenActions;
import org.openqa.selenium.WebElement;

public class ExercisesPage extends ScreenActions {

  @AndroidFindBy(xpath = "//*[@text='Samples List']")
  private static WebElement exercisesPageList;

  public String getExercisesPageList() {
    return getText(exercisesPageList, WaitStrategy.VISIBLE);
  }
}
