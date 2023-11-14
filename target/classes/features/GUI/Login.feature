Feature: Place order Journey


  Scenario: Validate successful login place order functionality
    Given open swag app and landed on login page
    And enter my user name
    And enter my password
    And click on login button
    When add most expensive two products to cart
    Then validate shopping cart open successfully
    Then validate on cart quantity for each item
    And click on checkout button to navigate to order submission page
    Then validate the redirection and order submission page title
    And enter first name
    And enter last name
    And enter postal code
    And click on continue button
    Then validate redirection to summary order page title and its page title
    Then validate on current URL to be overview page
    Then validate on calculation of subtotal
    When click on submit order
    Then validate on success message for complete the order




#  Scenario: Validate error message is displayed for invalid credentials
#    Given open swag app and landed on login page
#    And enter invalid user name
#    And enter invalid password
#    And click on login button
#    Then validate error message displayed successfully