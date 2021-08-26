Feature: Wiki search

  Scenario: Search content
    Given A browser
    When User searches "cucumber"
    Then A list of results is displayed