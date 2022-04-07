Feature: Workshop task

  Scenario Outline: Login in to mystore and add new address
    Given Page https://mystore-testlab.coderslab.pl/index.php?controller=authentication opened in browser
    When User sign
    Then User login: Iwona Kowalczyk
    When User click new address
    And User entered alias <alias> address <address> city <city> zip <zip> country <country> phone <phone>
    And User click save
    Then Address successfully added

    Examples:
      | alias | address | city     | zip   | country        | phone     |
      | home1 | porsta1 | alabama1 | 03320 | United Kingdom | 123123123 |
#      | home2 | porsta2 | alabama2 | 03320 | United Kingdom | 123123123 |
#      | home3 | porsta3 | alabama3 | 03320 | United Kingdom | 123123123 |