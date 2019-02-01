@amazon
  Feature: Amazon Search

    Scenario: Open Amazon.com, search for 3 sweet types, sort them by cheapest price and add to cart
      Given I open https://www.amazon.com
      Then I search for Snickers
      Then I sort by "Price: Low to High"
      And I pick the first item in the list
      And I add it to the cart