@validation
Feature: Create New User
  As a SDE-T I want to create new user using Create User API

  Scenario: Create New User Happy Path
    Given To create new user I have user-name as "John Doe"
    And I pass first-name as "John"
    And I pass last-name as "Doe"
    When I call Create User API
    Then I get a success response as HTTP 200 OK
    And A non-null user-response is received
    And user-response has non-null user-key
    And user-response has first-name as "John"
    And user-response has last-name as "Doe"
