package com.dsniatecki.sellyourcar.auction.dto.query;

import com.dsniatecki.sellyourcar.auction.dto.CarDTO;
import com.dsniatecki.sellyourcar.auction.dto.LocationDTO;
import com.dsniatecki.sellyourcar.auction.dto.OwnerDTO;
import lombok.Getter;

@Getter
public class AuctionCompleteQueryDTO {

    private final Long id;
    private final String title;
    private final Integer price;
    private final CarDTO car;
    private final OwnerDTO owner;
    private final LocationDTO location;
    private final Boolean isPremium;
    private final Integer daysExists;

    public AuctionCompleteQueryDTO(Long id, String title, Integer price, CarDTO car, OwnerDTO owner,
                                   LocationDTO location, Boolean isPremium, Integer daysExists) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.car = car;
        this.owner = owner;
        this.location = location;
        this.isPremium = isPremium;
        this.daysExists = daysExists;
    }

}
