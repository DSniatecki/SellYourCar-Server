package com.dsniatecki.sellyourcar.auction.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="cars")
public class Car {

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

    @OneToOne(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name="car_details_id")
    private CarDetails details;

}
