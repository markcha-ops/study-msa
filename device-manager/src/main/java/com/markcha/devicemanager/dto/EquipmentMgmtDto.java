package com.markcha.devicemanager.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.markcha.devicemanager.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonFilter("EquipmentMgmtDto")
public class EquipmentMgmtDto {
    private Integer id;

    private Integer wpId;

    private String equipmentName;

    private String energyPurposeName;

    private Integer locaiontMainId;

    private Integer locaiontSubId;

    private Byte importance;

    private Byte energyId;

    private LocalDateTime installDtm;

    private String SerialNumber;

    private String name;

    private List<WebAccessTagsDto> waTags ;

    public EquipmentMgmtDto(EquipmentMgmt equipmentMgmt) {
        this.id = equipmentMgmt.getId();
        this.wpId = equipmentMgmt.getWpId();
        this.equipmentName = equipmentMgmt.getEquipment().getName();
        this.energyPurposeName = equipmentMgmt.getEnergyPurpose().getName();
        this.locaiontMainId = equipmentMgmt.getLocaiontMainId();
        this.locaiontSubId = equipmentMgmt.getLocaiontSubId();
        this.importance = equipmentMgmt.getImportance();
        this.energyId = equipmentMgmt.getEnergyId();
        this.installDtm = equipmentMgmt.getInstallDtm();
        this.SerialNumber = equipmentMgmt.getSerialNumber();
        this.name = equipmentMgmt.getName();
        this.waTags = equipmentMgmt.getWaTags().stream()
                .map(webAccessTags -> {
                    return new WebAccessTagsDto(webAccessTags);
                }).collect(Collectors.toList());
    }

}
