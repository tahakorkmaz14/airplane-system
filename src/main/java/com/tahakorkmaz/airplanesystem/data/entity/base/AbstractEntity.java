package com.tahakorkmaz.airplanesystem.data.entity.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @JsonProperty("created_time")
    protected Date created;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @JsonProperty("updated_time")
    protected Date updated;
}