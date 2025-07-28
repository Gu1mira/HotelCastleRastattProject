Feature: Privacy Policy Page Verification
  @RegressionTest
  Scenario: Verify footer link and page content
    Given The user navigates to the homepage
    When The user spots the Datenschutz link in the footer, clicks it
    Then The URL should contain datenschutzerklaerung
    Then the page headings should be verified
    And Page links should be visible clickable accessible