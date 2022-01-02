package com.markcha.devicemanager.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MyKey implements Serializable {

    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "workplace_id", nullable = false)
    private int wpId;

    /** getters and setters **/
}