Feature: Navigation on Hotel Castle Rastatt website via Homepage Logo

  Background:
    Given Navigate to the Hotel Castle Rastatt

  Scenario: User navigates to homepage from different headers
    When the user clicks on the German language button
    And the user clicks on the headers and clicks on Homepage Logo
    Then the user confirms redirection to the homepage