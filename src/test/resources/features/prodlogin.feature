@prod
Feature: Login To Production
  In order to perform sucessful login
  As a user
  I want to enter correct username and password

  Background: 
    Given user navigates to facebook website
    When user validates the homepage title

  Scenario: In order to verify login to facebook
    Then user entered "valid" username
    And user entered "valid" password
    And user validates the capcha
    Then user "shouldbe" sucessfully logged in

  Scenario: In order to verify login to facebook
    Then user entered "invalid" username
    And user entered "invalid" password
    And user validates the capcha
    Then user "shouldnot" sucessfully logged in
