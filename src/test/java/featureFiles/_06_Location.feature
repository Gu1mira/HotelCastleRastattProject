Feature: Location

  Scenario: Location Functionality
    Given Navigate to the Hotel Castle Rastatt
    When The user clicks on the Anfahrt tab from the top menu
    And The user should see German language on the page
    And The user clicks on the English language option icon in the top right corner of the header menu
    And The user should see English language on the page. Keeping the same structure.
    And The user should see "SO FINDEN SIE UNS" and the explanatory text below it
    And The user should see Google Maps correctly