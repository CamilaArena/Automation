@purchase
  Feature: Add products to the cart

    @purchaseOneProduct
    Scenario: I add one product to the cart and make the order
      Given I'm in the home page
      When I select "phone" category and add "Samsung galaxy s6"
      When I complete the purchase
      Then I get a confirmation message