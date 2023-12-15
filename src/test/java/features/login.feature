@login
Feature: Log in

  @logInValidCredentials
  Scenario Outline: I log in with valid credentials
    Given I'm in the home page
    When I select Log In in the navbar
    When I complete the "<username>" and "<password>" with valid ones
    Then I get logged in

    Examples: credentials
      | username          | password |
      | a99@gmail.com     | 1234     |
      |test99@yahoo.com   | admin    |
      |test100@yahoo.com   | 1111    |


  @logInInvalidUsername
  Scenario Outline: I try to log in with invalid username
    Given I'm in the home page
    When I select Log In in the navbar
    When I complete the "<username>" with an invalid one
    Then I get a message indicating that User does not exist

    Examples: credentials
      | username      |
      | 124536512@gmail.com |
      | asdsa3242@gmail.com |
      | aff53deew@gmail.com |

  @logInInvalidPassword
  Scenario Outline: I try to log in with invalid password
    Given I'm in the home page
    When I select Log In in the navbar
    When I complete the "<username>" field with a valid username, and the "<password>" with an invalid one
    Then I get a message indicating that the password is incorrect

    Examples: credentials
      | username      | password |
      | a99@gmail.com | test     |
      |test99@yahoo.com | test |
      |test100@yahoo.com | test |