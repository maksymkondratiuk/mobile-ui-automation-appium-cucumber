package org.example.pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.pageobjects.screen.ScreenActions;
import org.openqa.selenium.WebElement;

public class LoginPage extends ScreenActions {

  @AndroidFindBy(accessibility = "username")
  private static WebElement txtFieldUsername;

  @AndroidFindBy(accessibility = "password")
  private static WebElement txtFieldPassword;

  @AndroidFindBy(accessibility = "login")
  private static WebElement btnLogin;

  @AndroidFindBy(xpath = "//*[@text='Back']")
  public WebElement backButton;

  public boolean isLoginPageDisplayed() {
    return isElementDisplayed(txtFieldUsername);
  }

  public LoginPage setUsername(String username) {
    enter(txtFieldUsername, username);
    return this;
  }

  public LoginPage setPassword(String password) {
    enter(txtFieldPassword, password);
    return this;
  }

  public ExercisesPage tapOnLogin() {
    click(btnLogin);
    return new ExercisesPage();
  }

  public LoginPage tapOnBack() {
    click(backButton);
    return new LoginPage();
  }

  public ExercisesPage login(String username, String password) {
    setUsername(username)
            .setPassword(password)
            .tapOnLogin();

    return new ExercisesPage();
  }
}
