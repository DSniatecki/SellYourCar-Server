package com.dsniatecki.sellyourcar.auction.dto.query;

import lombok.Getter;

@Getter
public class CarBasicQueryDTO {

    private final String brand;
    private final String model;
    private final Integer productionYear;

    public CarBasicQueryDTO(String brand, String model, Integer productionYear) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
    }

}
