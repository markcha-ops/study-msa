package com.markcha.devicemanager.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="webaccess_tags")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class WebAccessTags {
//    @EmbeddedId
//    private MyKey myKey;
    @Id
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "workplace_id", nullable = false)
    private int wpId;

    @Column(name="tagname", length = 32)
    private String tagName;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            })
//    @JoinTable(name = "post_tags",
//            joinColumns = { @JoinColumn(name = "post_id") },
//            inverseJoinColumns = { @JoinColumn(name = "tag_id") })
//    private Set<Tag> tags = new HashSet<Tag>();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_mgmt_id",referencedColumnName="id")
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


    public WebAccessTags() {
    }
}
