package com.markcha.devicemanager.dto;


import com.markcha.devicemanager.domain.EnergyPurpose;
import com.markcha.devicemanager.domain.Equipment;
import com.markcha.devicemanager.domain.WebAccessTags;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentMgmtInputDto {

    private Integer wpId;
    private Equipment equipment;
    private EnergyPurpose energyPurpose;
    private Integer locaiontMainId;
    private Integer locaiontSubId;

    private Byte importance;
    private Byte energyId;
    private LocalDateTime installDtm;
    private String SerialNumber;
    @Size(min=3)
    private String name;

    private List<WebAccessTags> waTags = new ArrayList<WebAccessTags>();

    private String remark;
    @Past
    private LocalDateTime created;
    private LocalDateTime updated;

    private Integer x;
    private Integer y;
}
