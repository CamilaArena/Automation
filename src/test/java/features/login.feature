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

  @logInEmptyPassword
  Scenario Outline: I try to log in with empty password
    Given I'm in the home page
    When I select Log In in the navbar
    When I complete the "<username>" field with a valid username, and empty password
    Then I get a message indicating that I should fill out Username and Password

    Examples: credentials
      | username      |
      | a99@gmail.com |
      |test99@yahoo.com |
      |test100@yahoo.com |

  @logInEmptyUsername
  Scenario Outline: I try to log in with empty username
    Given I'm in the home page
    When I select Log In in the navbar
    When I don't complete username field and complete the "<password>"
    Then I get a message indicating that I should fill out Username and Password

    Examples: credentials
      | password      |
      | a99@gmail.com |
      |test99@yahoo.com |
      |test100@yahoo.com |
