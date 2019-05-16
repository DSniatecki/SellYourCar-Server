package com.dsniatecki.sellyourcar.auction.model;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name="locations")
class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="country")
    private String country;

    @Column(name="province")
    private String province;

    @Column(name="city")
    private String city;

}
