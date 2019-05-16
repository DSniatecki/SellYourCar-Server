package com.dsniatecki.sellyourcar.auction;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="details")
class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="additional_features")
    private String additionalFeatures;

    @Column(name="description")
    private String description;

}
