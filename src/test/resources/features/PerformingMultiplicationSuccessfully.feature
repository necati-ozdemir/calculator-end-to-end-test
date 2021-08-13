#Ability: Student could succeed at MULTIPLICATION operation

#  Scenario Outline: Valid two numbers are supplied
#
#    Given Numbers are given <Number 1> and <Number 2>
#    When Zumrut wants to perform MULTIPLICATION those two numbers
#    Then Zumrut should see result <Result> and <Result Message> message
#
#    Examples:
#      | Number 1 | Number 2 | Result | Result Message |
#      | 2        | -8       | -16    | SUCCESS        |
#      | 1        | 7        | 7      | SUCCESS        |
#      | 0        | 105      | 0      | SUCCESS        |