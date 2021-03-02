@chrome
Feature: Orange HRM Login
  
  @smoke
  Scenario: 1 - Successful Admin Login using valid credentials
    Given user is on the "login" screen
    And user enter username "Admin" and password "admin123" to login
    Then user is on the "home" screen

  @smoke
  Scenario: 2 - Unsuccessful Admin Login using valid credentials
    Given user is on the "login" screen
    And user enter username "Admin" and password "admin-123" to login
    Then user is on the "login" screen