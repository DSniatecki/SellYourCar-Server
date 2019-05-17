package com.dsniatecki.sellyourcar.auction.dto.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class CarBasicQueryDTO {

    private final String brand;
    private final String model;
    private final Integer productionYear;

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public CarBasicQueryDTO(String brand, String model, Integer productionYear) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
    }

}
