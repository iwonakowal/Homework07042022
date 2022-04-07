Feature: Workshop task

  Scenario Outline: Login in to mystore and buy
    Given Page https://mystore-testlab.coderslab.pl/index.php?controller=authentication opened in browser
    When User sign
    Then User login: Iwona Kowalczyk
    When User click my store
    And User select Hummingbird printed t-shirt
    Then Discount is equal to 20 percent
    When User select size <size> and typed quantity <quantity>
    And Proceed order

    Examples:
      | size | quantity |
      | M    | 5        |


