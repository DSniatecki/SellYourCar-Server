package com.dsniatecki.sellyourcar.auction.dto.command;

import com.dsniatecki.sellyourcar.auction.dto.LocationDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AuctionEditionCommandDTO {

    private final String title;
    private final Integer price;
    private final CarEditionCommandDTO car;
    private final OwnerEditionCommandDTO owner;
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
