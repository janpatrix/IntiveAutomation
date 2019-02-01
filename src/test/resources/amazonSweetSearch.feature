@amazon
  Feature: Amazon Search

    Scenario: Open Amazon.com, search for Snickers, sort them by cheapest price and add to cart
      Given I open https://www.amazon.com
      Then I search for Snickers
      Then I sort by "Price: Low to High"
      And I pick the first item in the list
      Then I search for Skittles
      Then I sort by "Price: Low to High"
      And I pick the first item in the list
      Then I search for Twix
      Then I sort by "Price: Low to High"
      And I pick the first item in the list
