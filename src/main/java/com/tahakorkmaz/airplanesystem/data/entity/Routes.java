package com.tahakorkmaz.airplanesystem.data.entity;

import com.tahakorkmaz.airplanesystem.data.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name="route")
public class Routes extends AbstractEntity {

    @Column(name = "arrival_time")
    private Date arrTime;

    @Column(name = "departure_time")
    private Date depTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_from", nullable = false)
    private Airport deptAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_to", nullable = false)
    private Airport destAirport;
}