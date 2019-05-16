package com.dsniatecki.sellyourcar.auction;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="cars")
class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    @Column(name="production_year")
    private Integer productionYear;

    @Column(name="mileage")
    private Integer mileage;

    @Column(name="engine_power")
    private Integer enginePower;

    @Column(name="fuel_type")
    private String fuelType;

}
