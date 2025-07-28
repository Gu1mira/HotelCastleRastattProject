Feature: Navigation between header links

  @SmokeTest
  Scenario: Headers button functionality
    Given Navigate to the Hotel Castle Rastatt
    When The customer clicks the Start button
    And The customer should see the Castle Hotel Rastatt text on the Start page
    Then The customer clicks Über Uns button
    And The customer should see the Uber Uns text on the Über Uns page
    Then The customer clicks Anfahrt button
    And The customer should see the So Fınden Sıe Uns text on the Anfahrt page
    Then The customer clicks Aktivitäten button
    And The customer should see the Aktivitäten text on the Aktivitäten page
    Then The customer clicks the phone number button
    Then The customer clicks JETZT BUCHEN button
    And The customer should be redirected to the hotel's reservation page