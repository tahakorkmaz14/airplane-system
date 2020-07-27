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
@Table(name="flight")
public class Flight extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    public Routes route;

    @Column(name = "seats" , nullable = false)
    private Integer seats;

    @Column(name = "flight_date")
    private Date date;

    @Column(name = "flight_price" , nullable = false)
    private Double ticketPrice;
}