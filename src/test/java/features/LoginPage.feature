Feature: Login Feature Scenario

  Background: 
    Given I have launched the application

  @regression
  Scenario: This scenario is to define the the success path
    When I enter the correct username and password
    And I click on the Login Button
    Then I should land on the home page

  @sanity
  Scenario Outline: This scenario is to define the failure path
    When I enter the username as "<UserName>" and Password as "<Password>"
    And I click on the Login Button
    Then I should get the error message "Epic sadface: Username and password do not match any user in this service"

    Examples: 
      | UserName | Password |
      | abc_xyz  | Abc_efg  |
