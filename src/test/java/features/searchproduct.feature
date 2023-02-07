
Feature: Search and place the order for products

@Search
  Scenario Outline: Search experience for product search in both home and offer page
    Given User is on GreenKart landing page
    When User searched with shortname <Name> in homepage and extract actual name of product
    Then User search for <Name> shortname in offers page
    And Validate product name in offers page matches with home page

    Examples: 
      | Name |
      | Tom  |
      | Beet |
