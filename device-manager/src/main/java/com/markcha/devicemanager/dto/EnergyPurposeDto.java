package com.markcha.devicemanager.dto;

import com.markcha.devicemanager.domain.EquipmentMgmt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnergyPurposeDto {
    private Integer id;

    private String name;
    private List<EquipmentMgmt> equipmentMgmts = new ArrayList<EquipmentMgmt>();


}
