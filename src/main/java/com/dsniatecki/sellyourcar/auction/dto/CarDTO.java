package com.dsniatecki.sellyourcar.auction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public final class CarDTO {

    private final String brand;
    private final String model;
    private final Integer productionYear;
    private final Integer mileage;
    private final Integer enginePower;
    private final String fuelType;
    private final CarDetailsDTO carDetails;

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public CarDTO(@JsonProperty("brand")String brand,
                  @JsonProperty("model") String model,
                  @JsonProperty("productionYear") Integer productionYear,
                  @JsonProperty("mileage") Integer mileage,
                  @JsonProperty("enginePower") Integer enginePower,
                  @JsonProperty("fuelType") String fuelType,
                  @JsonProperty("carDetails") CarDetailsDTO carDetails) {

        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.enginePower = enginePower;
        this.fuelType = fuelType;
        this.carDetails = carDetails;
    }

}
