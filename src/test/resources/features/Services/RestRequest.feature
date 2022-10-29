@challenge
Feature: Test REST API

  @2.1
  Scenario: 2.1
    Given I have access to endpoint "/posts"
    When I create an user
    Then I should get the response code 201
    And the response with JSON schema "exampleSchema.json"

  Scenario: 2.2
    Given I have access to endpoint "/todos/1"
    When I make the query
    Then I should get the response code 200
    And the "title" should be 'delectus aut autem'
