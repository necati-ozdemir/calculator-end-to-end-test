Ability: Student could succeed at ADDITION operation

  @CAL-1
  Scenario: Valid two numbers are supplied

    Given The below numbers are given
      | firstValue | secondValue |
      | 6          | 8           |
    When Barkın wants to perform ADDITION those two numbers
    Then Barkın should see result 14 and SUCCESS message

  @CAL-1
  Scenario: Valid another two numbers are supplied

    Given The below numbers are given
      | firstValue | secondValue |
      | 1          | 2           |
    When Barkın wants to perform ADDITION those two numbers
    Then Barkın should see result 3 and SUCCESS message