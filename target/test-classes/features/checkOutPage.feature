Feature: Search and place the order for products

@CheckOutPage
  Scenario Outline: Search experience for product search in both home and offer page
    Given User is on GreenKart landing page
    When User searched with shortname <Name> in homepage and extract actual name of product
    And Added "3" items of the selected product item
    Then User proceeds to checkout page and validate the <Name> items to checkout page
    And verify user has ability to enter promocode and place the order

    Examples: 
      | Name |
      | Tom |
