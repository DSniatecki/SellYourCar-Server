package com.dsniatecki.sellyourcar.auction.command.dto;

import com.dsniatecki.sellyourcar.auction.dto.LocationDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
public final class AuctionEditionCommandDTO {

    @Size(min = 10, max = 80, message = "About Me must be between 10 and 80 characters")
    private final String title;

    @Positive
    @DecimalMax(value="1000000")
    private final Integer price;

    @Valid
    private final CarEditionCommandDTO car;

    @Valid
    private final OwnerEditionCommandDTO owner;

    @Valid
    private final LocationDTO location;

    @JsonCreator(mode= JsonCreator.Mode.PROPERTIES)
    public AuctionEditionCommandDTO (@JsonProperty("title") String title,
                                     @JsonProperty("price") Integer price,
                                     @JsonProperty("car") CarEditionCommandDTO car,
                                     @JsonProperty("owner") OwnerEditionCommandDTO owner,
                                     @JsonProperty("location") LocationDTO location) {
        this.title = title;
        this.price = price;
        this.car = car;
        this.owner = owner;
        this.location = location;
    }

}
