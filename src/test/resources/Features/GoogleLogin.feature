
Feature: Validate Google login flow

  Scenario: Navigate to Google login window
    Given the user is on the ZigWheels homepage
    When the user clicks the login button
    Then all the login options should be displayed correctly
  
  Scenario: User logins through Google his/her Google Account 
    When clicks the Google login option
    Then the Google login window should open

  Scenario: Validate email error message
    When the user enters email "praveen@gmail.com"
    Then the email error message should be displayed