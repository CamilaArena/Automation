@login
Feature: Log in

  @logInValidCredentials
  Scenario: I log in with valid credentials
    Given I'm in the home page
    When I select Log In in the navbar
    When I complete the username and password with valid ones
    Then I get logged in

  @logInInvalidUsername
  Scenario: I try to log in with invalid username
    Given I'm in the home page
    When I select Log In in the navbar
    When I complete the username with an invalid one
    Then I get a message indicating that User does not exist

  @logInInvalidPassword
  Scenario: I try to log in with invalid username
    Given I'm in the home page
    When I select Log In in the navbar
    When I complete the username field with a valid username, and the password with an invalid one
    Then I get a message indicating that the password is incorrect