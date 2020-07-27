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
@Table(name = "ticket",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "ticket_number"
                })})
public class Ticket extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @Column(name = "ticket_price",nullable = false)
    private Double price;

    @Column(name = "ticket_number")
    private String number;

    @Column(name = "card_number")
    public String cardNumber;
}