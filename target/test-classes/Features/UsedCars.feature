Feature: Validate used cars in Chennai

  Scenario: Search for used cars in Chennai
    Given the user is on the ZigWheels homepage
    When the user searches for "Used Cars In Chen"
    Then the used car list should be displayed

  Scenario: Validate popular models
    Then popular car models should be visible
