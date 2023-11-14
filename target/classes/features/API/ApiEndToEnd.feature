Feature: Place order functionality


  Scenario: Validate end to end create ,edit,delete order functionality
    Given run precondition and prepare testData
    Given I get all available books
    When I place an order with a specific book
    Then I validate that post request happened successfully with same customer name
    Then I get my orders and check the order is placed successfully
    When I replace the order with new customer name
    Then I check the order updated with new customer name
    When I cancel my last order
    Then I check the order id has been deleted successfully