Feature: Jetzt Buchen/Book Now

  Background:
    Given Navigate to the Hotel Castle

  Scenario: Booking Functionality
    When Customer clicks on the element in Headers
      | Jetzt Buchen |
    And Customer clicks on the element in Dialog Content
      | Search Start Date |
    Then Verifies that previous days, month and years cannot be selected
    When Customer selects a check-in date
    When Customer clicks on the element in Dialog Content
      | Search End Date |
    Then Verifies that only dates after the check-in date can be selected
    When Customer selects a check-out date
    And Verifies that the filtered options shown in the page
    When Customer selects a number of rooms, number of kids and guests
    Then Verifies that the Jetzt Buchen button activated
    And Customer clicks on the element in Dialog Content
      | Jetzt Buchen |