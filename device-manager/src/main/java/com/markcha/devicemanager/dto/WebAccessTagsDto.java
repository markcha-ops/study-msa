package com.markcha.devicemanager.dto;

import com.markcha.devicemanager.domain.EquipmentMgmt;
import com.markcha.devicemanager.domain.WebAccessTags;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Builder
@AllArgsConstructor
public class WebAccessTagsDto {
    private int id;

    private int wpId;

    private String tagName;

    private String tagDescription;

    private String unit;

    private Boolean unitConversion;

    private Boolean isTrend;

    private Integer loggingTime;

    private String energyType;

    private Boolean isAlarm;

    private String equipmentMgmtName;

    public WebAccessTagsDto(WebAccessTags webAccessTags) {
        this.id = webAccessTags.getId();
        this.wpId = webAccessTags.getWpId();
        this.tagName = webAccessTags.getTagName();
        this.tagDescription = webAccessTags.getTagDescription();
        this.unit = webAccessTags.getUnit();
        this.unitConversion = webAccessTags.getUnitConversion();
        this.isTrend = webAccessTags.getIsTrend();
        this.loggingTime = webAccessTags.getLoggingTime();
        this.energyType = webAccessTags.getEnergyType();
        this.isAlarm = webAccessTags.getIsAlarm();
        this.equipmentMgmtName = webAccessTags.getEquipmentMgmt().getName();
    }
}
