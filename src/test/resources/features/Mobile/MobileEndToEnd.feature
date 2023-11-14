Feature: Login Journey


  Scenario: Validate successful login functionality
    Given open swag app and landed on login page
    And enter my user name
    And enter my password
    And click on login button
    Then validate land on the home page successfully




  Scenario: Validate error message is displayed for invalid credentials
    Given open swag app and landed on login page
    And enter invalid user name
    And enter invalid password
    And click on login button
    Then validate error message displayed successfully for mobile