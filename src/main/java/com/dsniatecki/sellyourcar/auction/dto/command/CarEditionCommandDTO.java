package com.dsniatecki.sellyourcar.auction.dto.command;

import com.dsniatecki.sellyourcar.auction.dto.CarDetailsDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CarEditionCommandDTO {

    private final Integer productionYear;
    private final Integer mileage;
    private final Integer enginePower;
    private final String fuelType;
    private final CarDetailsDTO carDetails;

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public CarEditionCommandDTO(
                  @JsonProperty("productionYear") Integer productionYear,
                  @JsonProperty("mileage") Integer mileage,
                  @JsonProperty("enginePower") Integer enginePower,
                  @JsonProperty("fuelType") String fuelType,
                  @JsonProperty("carDetails") CarDetailsDTO carDetails) {


        this.productionYear = productionYear;
        this.mileage = mileage;
        this.enginePower = enginePower;
        this.fuelType = fuelType;
        this.carDetails = carDetails;
    }

}
