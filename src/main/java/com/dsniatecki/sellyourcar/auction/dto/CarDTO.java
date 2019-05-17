package com.dsniatecki.sellyourcar.auction.dto;

import com.dsniatecki.sellyourcar.auction.model.CarDetails;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class CarDTO {

    private final String brand;
    private final String model;
    private final Integer productionYear;
    private final Integer mileage;
    private final Integer enginePower;
    private final String fuelType;
    private final CarDetailsDTO carDetails;

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public CarDTO(String brand, String model, Integer productionYear, Integer mileage,
                  Integer enginePower, String fuelType, CarDetailsDTO carDetails) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.enginePower = enginePower;
        this.fuelType = fuelType;
        this.carDetails = carDetails;
    }
}
