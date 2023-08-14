package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.ExercisesPage;
import org.junit.Assert;

public class LoginSteps {

  @When("^User enter username as \"([^\"]*)\"$")
  public void userEnterUsernameAs(String username) {
    new LoginPage().setUsername(username);
  }

  @When("^User enter password as \"([^\"]*)\"$")
  public void userEnterPasswordAs(String password) {
    new LoginPage().setPassword(password);
  }

  @When("^clicks on login$")
  public void clickOnLogin() {
    new LoginPage().tapOnLogin();
  }

  @When("User Login with username: {string} and password: {string} and press Login")
  public void userLogin(String username, String password) {
    new LoginPage().login(username, password);
  }

  @Then("User should see list of exercises: {string}")
  public void userShouldSeeExercisesList(String title) {
    Assert.assertEquals(new ExercisesPage().getExercisesPageList(), title);
  }

  @Then("Back to Login Page")
  public void backToLoginPage() {
    new LoginPage().tapOnBack().tapOnBack();
  }

  @When("User enter username: {string} and password: {string}")
  public void userEnterUsernameAndPassword(String username, String password) {
    new LoginPage().setUsername(username).setPassword(password);
  }
}
