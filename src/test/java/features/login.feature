@login
Feature: Log in

  @logInValidCredentials
  Scenario: I log in with valid credentials
    Given I'm in the home page
    When I select Log In in the navbar
    When I complete the username and password with valid ones
    Then I get logged in

  @logInInvalidCredentials
  Scenario: I log in with valid credentials
    Given I'm in the home page
    When I select Log In in the navbar
    When I complete the username and password with invalid ones
    Then I get a message indicating that the password is incorrect