Feature: Valuation Management

  Scenario: Get an existing account
    Given an valuation with Parameters
    When the user sends a GET request to "/test"
    Then the response status code of getting an account should be 200
    And the response body should contain the account details