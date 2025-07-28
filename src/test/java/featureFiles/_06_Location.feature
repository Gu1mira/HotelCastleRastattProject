Feature: Location
  @SmokeTest
  Scenario: Verify language switch and map visibility on the Location page
    Given Navigate to the Hotel Castle Rastatt in German
    And The user clicks on the Anfahrt tab from the top menu
    Then The user should see German language on the page
    When The user clicks on the English language option icon in the top right corner of the header menu
    And The user should see "SO FINDEN SIE UNS" and the explanatory text below it
    And The user should see Google Maps correctly
