Feature: Google Search Automation

  Scenario: Searching for Nutella on Google
    Given User is on Google homepage
    When User searches for "Nutella"
    Then The first result should be displayed
