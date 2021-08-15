Ability: Kullanıcı, Mod 1 için frekans atlama yeteneğinde kullanılmayacak frekansları belirleyebilmelidir

  Scenario Outline: Mutlu Mod 1 komünikasyon modunda 51 frekans arasından iptal edilecek frekansları belirleyebilmelidir

    Given Mod 1 için iptal edilecek <Frequency Numbers> adet frekans belirlenmiş
    When Mutlu frekansları doğrulamak istediğinde
    Then Mutlu <Result Message> sonucunu görebilmelidir

    Examples:
      | Frequency Numbers | Result Message |
      | 0                 | SUCCESS        |
      | 5                 | SUCCESS        |
      | 14                | SUCCESS        |
      | 15                | WARNING        |
      | 16                | WARNING        |
      | 51                | WARNING        |
