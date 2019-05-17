package com.dsniatecki.sellyourcar.auction.model;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

@Data
@Builder
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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="cars_details_id")
    private CarDetails details;

}
