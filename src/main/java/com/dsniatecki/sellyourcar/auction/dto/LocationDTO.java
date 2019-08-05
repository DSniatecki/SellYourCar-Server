package com.dsniatecki.sellyourcar.auction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public final class LocationDTO {

    @NotNull @Size(min = 2, max = 80, message = "About Me must be between 2 and 80 characters")
    private final String country;

    @NotNull @Size(min = 2, max = 80, message = "About Me must be between 2 and 80 characters")
    private final String province;

    @NotNull @Size(min = 2, max = 80, message = "About Me must be between 2 and 80 characters")
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
