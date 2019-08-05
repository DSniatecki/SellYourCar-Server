package com.dsniatecki.sellyourcar.auction.command.dto;

import com.dsniatecki.sellyourcar.auction.dto.CarDetailsDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
public final class CarEditionCommandDTO {

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
