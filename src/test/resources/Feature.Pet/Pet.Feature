Feature: Manage Pet

  I can manage Pet in my store such as find, update, create new pets.

  Scenario Outline: Get Pet By Pet ID
    Given I provide petID "<petid>"
    When I send request to get Pet By ID
    Then I Test
    Then I get Pet

    Examples: Input Get Pet
      | petid |
      | 9     |

  Scenario Outline: Add new Pet
    Given I provide a new pet "<petid>" and "<name>" and "status"
    When  I send request to create a new Pet
    Then I have a new pet created

    Examples: Create a new pet
      | petid | name  | status    |
      | 9     | Holly | available |

