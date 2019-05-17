package com.dsniatecki.sellyourcar.auction.dto.command;

import com.dsniatecki.sellyourcar.auction.dto.CarDTO;
import com.dsniatecki.sellyourcar.auction.dto.LocationDTO;
import com.dsniatecki.sellyourcar.auction.dto.OwnerDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public final class AuctionCreateCommandDTO {

    private final String title;
    private final Integer price;
    private final CarDTO car;
    private final OwnerDTO owner;
    private final LocationDTO location;

    @JsonCreator(mode= JsonCreator.Mode.PROPERTIES)
    public AuctionCreateCommandDTO(@JsonProperty("title") String title,
                                   @JsonProperty("price") Integer price,
                                   @JsonProperty("car") CarDTO car,
                                   @JsonProperty("owner") OwnerDTO owner,
                                   @JsonProperty("location") LocationDTO location) {
        this.title = title;
        this.price = price;
        this.car = car;
        this.owner = owner;
        this.location = location;
    }

}
