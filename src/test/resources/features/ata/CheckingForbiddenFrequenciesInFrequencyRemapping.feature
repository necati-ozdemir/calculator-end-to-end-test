Ability: Kullanıcı, yasaklı frekansları listeleyebilecektir

  Scenario Outline: Mutlu 1009 ve 1052 Mhz frekans aralığını IFF Interrogation için yasaklı olduğunu listeleyebilecektir

    Given <Communication Mode> için
    When Mutlu IFF Interrogation için yasaklı frekansları görmek istediğinde
    Then 1009 ve 1052 Mhz frekans aralığını IFF Interrogation için yasaklı olduğunu görebilmelidir

    Examples:
      | Communication Mode |
      | Mod 1              |
      | Mod 2              |
      | Mod 4              |

  Scenario Outline: Mutlu 1066 ve 1112 Mhz frekans aralığını IFF Replays için yasaklı olduğunu listeleyebilecektir

    Given <Communication Mode> için
    When Mutlu IFF Replays için yasaklı frekansları görmek istediğinde
    Then 1066 ve 1112 Mhz frekans aralığını IFF Replays için yasaklı olduğunu görebilmelidir

    Examples:
      | Communication Mode |
      | Mod 1              |
      | Mod 2              |
      | Mod 4              |


