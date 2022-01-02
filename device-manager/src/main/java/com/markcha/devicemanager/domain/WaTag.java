package com.markcha.devicemanager.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="webaccess_tags")
public class WaTag {
    @EmbeddedId
    private MyKey myKey;

    @Column(name="tagname", length = 32)
    private String tagName;



    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "equipment_mgmt_id")
    private EquipmentMgmt equipmentMgmt;

    @Column(name = "tag_description", length = 255)
    private String tagDescription;

    @Column(name = "unit", length = 10)
    private String unit;

    @Column(name = "unit_conversion")
    private Boolean unitConversion;

    @Column(name = "is_trend")
    private Boolean isTrend;
    @Column(name = "logging_time")
    private Integer loggingTime;
    @Column(name = "energy_type", length = 50)
    private String energyType;
    @Column(name = "is_alarm")
    private Boolean isAlarm;


}
