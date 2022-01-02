package com.markcha.webaccess.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name="history_hour",
        uniqueConstraints={
                @UniqueConstraint(
                        columnNames={"timestamp","tagname"}
                )
        })
public class HistoryHour {
    @Id
    @Column(name="timestamp", columnDefinition = "DATETIME")
    private LocalDateTime timestamp;

    @Column(name="tagname", length = 50)
    private String tagname;

    @Column(name="usage")
    private Double usage;

}
