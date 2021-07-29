Ability: Student could succeed at ADDITION operation

  @CAL-1
  Scenario: Valid two numbers are supplied

    Given The below numbers are given
      | firstValue | secondValue |
      | 10          | 5           |
    When Barkın wants to perform ADDITION those two numbers
    Then Barkın should see result 15 and SUCCESS message

  @CAL-1
  Scenario: Valid another two numbers are supplied

    Given The below numbers are given
      | firstValue | secondValue |
      | 4          | 2           |
    When Barkın wants to perform ADDITION those two numbers
    Then Barkın should see result 6 and SUCCESS message