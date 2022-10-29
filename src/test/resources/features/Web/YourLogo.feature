@challenge
Feature: Test challenge for your logo.

  Background: User go to login page
    Given I navigate to the login page on "Chrome"
    And I submit proper username and password

  @1.1
  Scenario: 1.1
    Given I navigate to 'WOMEN' section
    And I select 'BLOUSES' sub category
    When I add the first garment to the cart
    Then I print the value of the garment

  @1.2
  Scenario: 1.2
    When I search 'jeans'
    Then I should visualize the message 'No results were found for your search "jeans"'