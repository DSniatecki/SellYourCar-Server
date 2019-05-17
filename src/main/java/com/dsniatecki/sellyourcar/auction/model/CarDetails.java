package com.dsniatecki.sellyourcar.auction.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cars_details")
public class CarDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="additional_features")
    private String features;

    @Column(name="long_description")
    private String description;

    public CarDetails(String features, String description) {
        this.features = features;
        this.description = description;
    }
}
