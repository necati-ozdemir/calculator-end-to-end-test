Ability: Student cannot be successful at addition operation

  Scenario: Either of any value is not supplied
    Given either of any value is not given
    When Necati wants to continue to ADDITION operation
    Then Necati should see a warning notification