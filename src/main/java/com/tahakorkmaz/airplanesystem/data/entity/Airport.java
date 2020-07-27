package com.tahakorkmaz.airplanesystem.data.entity;

import com.tahakorkmaz.airplanesystem.data.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="airport")
public class Airport extends AbstractEntity {

    @Column(name = "airport_name")
    private String airportName;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;
}
