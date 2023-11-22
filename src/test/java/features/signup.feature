@signup
Feature: Sign up

  @logInValidCredentials
  Scenario: I sign up creating a new username and password
    Given I'm in the home page
    When I select Sign up in the navbar
    When I create a new username and complete the username and password fields
    Then I get a success message