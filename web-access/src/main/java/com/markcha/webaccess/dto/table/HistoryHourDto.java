package com.markcha.webaccess.dto.table;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HistoryHourDto {
    Integer H;
    Double Usage;
    Double beforeOneDayUseage;
    Double beforeOneMonthUseage;
    Double beforeOneYearUseage;
}
