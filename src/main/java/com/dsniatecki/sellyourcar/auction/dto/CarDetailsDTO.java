package com.dsniatecki.sellyourcar.auction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CarDetailsDTO {

    private final String features;
    private final String description;
    
    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public CarDetailsDTO(@JsonProperty("features") String features,
                         @JsonProperty("description") String description) {

        this.features = features;
        this.description = description;
    }

}
