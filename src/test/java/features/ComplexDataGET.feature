Feature: ComplexDataGet
  @test
  Scenario: Verify GET operation for complex data
    Given I perform authentication operation for "/auth/login" with body
      | email              | password  |
      | srikantpanda@email.com   | srikantpanda |
    And I perform GET operation with path parameter for address "/location/"
      | id |
      | 1  |
    Then I should see the street name as "1st street"
