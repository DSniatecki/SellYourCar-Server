package com.dsniatecki.sellyourcar.auction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public final class CarDetailsDTO {

    @NotNull @Size(min = 10, max = 200, message = "About Me must be between 10 and 200 characters")
    private final String features;

    @NotNull @Size(min = 10, max = 500, message = "About Me must be between 10 and 500 characters")
    private final String description;
    
    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public CarDetailsDTO(@JsonProperty("features") String features,
                         @JsonProperty("description") String description) {
        this.features = features;
        this.description = description;
    }

}
