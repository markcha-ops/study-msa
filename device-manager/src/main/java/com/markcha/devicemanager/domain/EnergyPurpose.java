package com.markcha.devicemanager.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="energy_purpose")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class EnergyPurpose {

    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "energyPurpose", fetch = FetchType.EAGER)
    private List<EquipmentMgmt> equipmentMgmts = new ArrayList<EquipmentMgmt>();
}
