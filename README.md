# mobile-ui-automation-appium-cucumber

1. Install Java JDK and IntelliJ IDEA
2. Install NodeJS
3. Install Android studio and create emulator with name "Pixel 3a API 30" and Android Version ~9 (test app is old)
4. Install Appium Server using *npm install -g appium*
5. Install UiAutomator2 using *appium driver install uiautomator2*
6. On the FrameworkConstants class find APPIUM_JS_PATH and put there path to your "/AppData/Roaming/npm/node_modules/appium/build/lib/main.js" or create an environment variable APPIUM_JS with such pass and uncomment commented line
7. To run the tests use RunnerTest class
8. To check TestRun report go to /mobile-ui-automation-appium-cucumber/target/cucumber-html-output/cucumber-html-report.html
