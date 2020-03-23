Feature: Relevancy on the page

  Scenario Outline: Search for a keyword on Google
    Given User Launch Chrome browser
    When User opens url "<url>"
    And Searches for "<keyword>" and clicks to search button
    Then sees 70% of the words as "<keyword>"
    And close the bowser

    Examples: 
      | url                     |  | keyword |
      | https://www.google.com/ |  | pen     |
      | https://www.bing.com/   |  | pen     |
      | https://duckduckgo.com/ |  | pen     |
