Feature: Navigation between header links

  Background:
    Given Navigate to the Hotel Castle Rastatt

    Scenario: Headers button functionality
      When The customer click  on the english language icon
      And The customer clicks the Home button
      Then The customer should see the Castle Hotel Rastatt text on the Home page
      And The customer clicks About Us button
      Then The customer should see information about the hotel when they click the About Us button
      And The customer clicks Location button
      Then The customer should obtain information about the hotel's location when they click the Location button
      And The customer clicks Activities button
      Then The customer should see the Activities text on the Activities page
      And The customer clicks the phone number button
      Then The customer clicks JETZT BUCHEN button
      And The customer should be redirected to the hotel's reservation page