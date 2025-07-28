Feature:  Privacy Policy Page Verification in English
  Background:
    Given Navigate to the Hotel Castle Rastatt
  @RegressionTest
    Scenario: User clicks on Datenschutz link and presses on all links
      When The customer click  on the english language icon
      And The user spots the Datenschutz link in the footer, clicks it
      Then The URL should contain datenschutzerklaerung
      When The user clicks on all active links and opens them one by one
      Then The user verifies redirection to correct webpages