package com.dsniatecki.sellyourcar.auction.dto.command;

import com.dsniatecki.sellyourcar.auction.dto.CarDTO;
import com.dsniatecki.sellyourcar.auction.dto.LocationDTO;
import com.dsniatecki.sellyourcar.auction.dto.OwnerDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class AuctionCommandDTO {

    private final String title;
    private final Integer price;
    private final CarDTO car;
    private final OwnerDTO owner;
    private final LocationDTO location;
    private final Boolean isPremium;

    @JsonCreator(mode= JsonCreator.Mode.PROPERTIES)
    public AuctionCommandDTO(String title, Integer price, CarDTO car, OwnerDTO owner,
                             LocationDTO location, Boolean isPremium) {
        this.title = title;
        this.price = price;
        this.car = car;
        this.owner = owner;
        this.location = location;
        this.isPremium = isPremium;
    }
}
