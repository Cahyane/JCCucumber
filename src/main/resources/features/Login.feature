Feature: Login User HRM
  Scenario: User valid login into web HRM
    Given User open browser and url
    When User enter valid username
    And User enter valid password
    And User click button login
    Then User go to page Dashboard

  Scenario: User invalid login
    When User click button logout
    And User enter invalid username
    And User enter invalid password
    And User click button login
    Then User get message invalid credentials

  Scenario: User enter invalid username login
    When User enter invalid username login
    And User enter valid password
    And User click button login
    Then User get message invalid credentials

  Scenario: User enter empty password login
    When User enter valid username
    And User enter empty password
    And User click button login
    Then User get message invalid credentials