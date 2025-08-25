Feature: Validate upcoming Honda bikes

  Scenario: Navigate to upcoming Honda bikes
    Given the user is on the ZigWheels homepage
    When the user searches for "Upcoming Honda"
    Then the page title should be "Honda Upcoming Bikes in India - Check Price, Launch Date, Images and Latest News"

  Scenario: Validate Honda bike list
    Then all listed bikes should be of brand "Honda"

  Scenario: Validate bike card details
    Then all bike cards should have name, price, and launch date

  Scenario: Validate bike price threshold
    Then at least one bike should be priced below ₹4 Lakhs
