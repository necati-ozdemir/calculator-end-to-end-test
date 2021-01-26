Ability: Student could succeed at SUBTRACTION operation

  @CAL-2
  Scenario: Valid two numbers are supplied

    Given The below numbers are given
      | firstValue | secondValue |
      | 6          | 8           |
     When Barkın wants to perform SUBTRACTION those two numbers
     Then Barkın should see result -2 and SUCCESS message
