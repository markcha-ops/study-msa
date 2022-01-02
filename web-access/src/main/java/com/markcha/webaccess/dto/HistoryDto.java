package com.markcha.webaccess.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDto {
    private Integer timestamp;

    private String tagname;

    private Double usage;


}
