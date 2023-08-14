@Login
Feature: Login test

    @ValidLogin
    Scenario: Login with valid username and password
        When User enter username: "admin" and password: "admin"
        And clicks on login
        Then User should see list of exercises: "Samples List"