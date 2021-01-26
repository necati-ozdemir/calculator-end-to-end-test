Ability: Student cannot be successful at subtraction operation

  @CAL-11
  Scenario: Either of any value is not supplied
    Given either of any value is not given
    When Necati wants to continue to SUBTRACTION operation
    Then Necati should see a warning notification