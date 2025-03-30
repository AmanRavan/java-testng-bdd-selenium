@Regression
Feature: Full test coverage

  @Smoke
  Scenario: TestCase_01
    Given I navigate to the careers website
    Then I handle the cookies alert
    When I click on the "More" button for professionals
    Then I should see the "Search by:" heading

  @Smoke
  Scenario: TestCase_02
    Given I navigate to the careers website
    Then I handle the cookies alert

  @Smoke
  Scenario: TestCase_03
    Given I navigate to the careers website
    Then I handle the cookies alert
    When I select "Technology" from the Division Category dropdown

  @Sanity
  Scenario: TestCase_04
    Given I navigate to the careers website
    Then I handle the cookies alert
    When I select "India" from the Country dropdown

  @Sanity
  Scenario: TestCase_05
    Given I navigate to the careers website
    Then I handle the cookies alert
    When I select "Analyst" from the Corporate title dropdown

  @Sanity
  Scenario: TestCase_06
    Given I navigate to the careers website
    Then I handle the cookies alert
    When I select "Full time" from the availability dropdown

  @Sanity
  Scenario: TestCase_07
    Given I navigate to the careers website
    Then I handle the cookies alert
    When I enter "Tester" in the keyword input box

  @Sanity
  Scenario: TestCase_08
    Given I navigate to the careers website
    Then I handle the cookies alert
    When I click on the "Search" button

  Scenario: TestCase_09
    Given I navigate to the careers website
    Then I handle the cookies alert
    Then I should see search results containing the keyword "Tester"

  Scenario: TestCase_10
    Given I navigate to the careers website
    Then I handle the cookies alert
    And I click on the "More" button for professionals
