package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.pageobjects.LoginPage;
import org.example.utils.screenrecording.ScreenRecordingService;
import org.example.utils.screenshot.ScreenshotService;

public class Hooks {

  @Before
  public void setUp() {
    ScreenRecordingService.startRecording();
    if (!new LoginPage().isLoginPageDisplayed())
    {
      new LoginSteps().backToLoginPage();
    }
  }

  @After
  public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
      scenario.attach(ScreenshotService.getScreenshotAsBytes(),
                      "image/png", scenario.getName());
      new LoginSteps().backToLoginPage();
    }
    ScreenRecordingService.stopRecording(scenario.getName());
  }
}
