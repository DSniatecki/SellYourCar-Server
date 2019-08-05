package com.dsniatecki.sellyourcar.auction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
public final class CarDTO {

    @NotNull @Size(min = 1, max = 80, message = "About Me must be between 1 and 80 characters")
    private final String brand;

    @NotNull @Size(min = 1, max = 80, message = "About Me must be between 1 and 80 characters")
    private final String model;

    @NotNull @DecimalMin(value="1890") @DecimalMax(value="2020")
    private final Integer productionYear;

    @NotNull @Positive @DecimalMax(value="1000000")
    private final Integer mileage;

    @NotNull @Positive @DecimalMax(value="2000" , message = "About Me must be between 1 and 2000")
    private final Integer enginePower;

    @NotNull @Size(min = 2, max = 20, message = "About Me must be between 2 and 20 characters")
    private final String fuelType;

    @NotNull @Valid
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
