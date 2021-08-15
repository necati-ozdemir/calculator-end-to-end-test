Ability: Kullanıcı, 51 frekansı listeleyebilecektir

  Scenario Outline: Mutlu frekans atlamada kullanılabilecek frekansları listeleyebilecektir

    Given <Communication Mode> için
    When Mutlu frekansları görmek istediğinde
    Then Mutlu <Frequency List> frekanslarını listeleyebilmelidir
      | Frequency List                                                                                                                                                                                                                                                                                                            |
      | 969 972 975 978 981 984 987 990 993 996 999 1002 1005 1008 1011	1014 1017 1020 1023	1026 1029 1032 1035	1038 1041 1044 1047	1050 1053 1056 1059	1062 1065 1113 1116	1119 1122 1125 1128	1131 1134 1137 1140	1143 1146 1149 1152	1155 1158 1161 1164	1167 1170 1173 1176 1179 1182 1185 1188 1191 1194 1197 1200 1203 1206 |

    Examples:
      | Communication Mode |
      | Mod 1              |
      | Mod 2              |
      | Mod 4              |