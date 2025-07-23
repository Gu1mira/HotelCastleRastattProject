Feature: Hotel room selection and booking process functionality

  Scenario: Hotel Room Steps

    Given Navigate to the hotel castle rastatt
    When The customer click JetztBuchen button
    And The customer enters check in and checkout dates
    And  The customer click suchen button
    When The customer chooses the number of adults,children,and rooms
    Then The Customer verifies adult and child choices with information on the maximum number of rooms
    Then The Customer chooses the number of rooms and verify