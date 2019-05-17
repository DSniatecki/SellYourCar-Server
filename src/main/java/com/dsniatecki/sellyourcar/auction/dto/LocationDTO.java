package com.dsniatecki.sellyourcar.auction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public final class LocationDTO {

    private final String country;
    private final String province;
    private final String city;

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public LocationDTO(@JsonProperty("country") String country,
                       @JsonProperty("province") String province,
                       @JsonProperty("city") String city) {

        this.country = country;
        this.province = province;
        this.city = city;
    }

}
