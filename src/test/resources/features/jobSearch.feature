Feature: Job Search on Deutsche Bank Careers

  Scenario: Search for jobs with specific criteria
    Given I navigate to the careers website
    Then I handle the cookies alert
    When I click on the "More" button for professionals
    Then I should see the "Search by:" heading
    When I select "Technology" from the Division Category dropdown
    And I select "India" from the Country dropdown
    And I select "Analyst" from the Corporate title dropdown
    And I select "Full time" from the availability dropdown
    And I enter "Tester" in the keyword input box
    And I click on the "Search" button
    Then I should see search results containing the keyword "Tester"