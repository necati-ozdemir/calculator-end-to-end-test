Ability: Student could succeed at SUBTRACTION operation

  @CAL-20
  Scenario: Valid two numbers are supplied

    Given The below numbers are given
      | firstValue | secondValue |
      | 9          | 8           |
     When Barkın wants to perform SUBTRACTION those two numbers
     Then Barkın should see result 1 and SUCCESS message

  @CAL-20
  Scenario: Valid another two numbers are supplied

    Given The below numbers are given
      | firstValue | secondValue |
      | 8          | 3           |
    When Barkın wants to perform SUBTRACTION those two numbers
    Then Barkın should see result 5 and SUCCESS message
