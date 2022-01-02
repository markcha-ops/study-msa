package com.markcha.devicemanager.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name ="equipment_mgmt")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class EquipmentMgmt {
    @Id
    private Integer id;

    @Column(name= "workplace_id")
    private Integer wpId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_name")
    private Equipment equipment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "energy_purpose_name")
    private EnergyPurpose energyPurpose;
    @Column(name = "Location_main_id")
    private Integer locaiontMainId;

    @Column(name = "Location_sub_id")
    private Integer locaiontSubId;

    private Byte importance;

    @Column(name = "energy_id")
    private Byte energyId;

    @Column(name = "install_dtm")
    private LocalDateTime installDtm;

    @Column(name = "serial_num", length = 50)
    private String SerialNumber;


    @Column(name = "name", length = 50)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "equipmentMgmt",fetch = FetchType.LAZY)
    private List<WebAccessTags> waTags = new ArrayList<WebAccessTags>();

    @Column(name = "remark", length = 50)
    private String remark;
    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "updated")
    private LocalDateTime updated;

    private Integer x;
    private Integer y;



}
