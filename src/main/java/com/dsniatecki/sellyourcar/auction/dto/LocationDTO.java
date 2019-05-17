package com.dsniatecki.sellyourcar.auction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class LocationDTO {

    private final String country;
    private final String province;
    private final String city;

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public LocationDTO(String country, String province, String city) {
        this.country = country;
        this.province = province;
        this.city = city;
    }
}
