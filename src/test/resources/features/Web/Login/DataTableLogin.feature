@prod
Feature: Login to Website
  In order to perform sucessful login try run with multiple username and password

  Scenario: User login scenario
    Given User at the login page of application
    When User login with the following username and password
    |username1|password1|
    |username2|password2|
    |username3|password3|
    |username4|password4|
    Then User should be able to login with correct username and password

  Scenario Outline: Scenario Outline code
    Given Required data here <param1>
    When user enter <param2>
    Then I enter <param3>
    Examples:
    |param1|param2|param3|
    |vp1   |vp2   |vp3   |
    |vp11  |vp22  |vp33  |


