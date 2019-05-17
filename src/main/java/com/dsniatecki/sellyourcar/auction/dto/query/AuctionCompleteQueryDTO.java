package com.dsniatecki.sellyourcar.auction.dto.query;

import com.dsniatecki.sellyourcar.auction.dto.CarDTO;
import com.dsniatecki.sellyourcar.auction.dto.LocationDTO;
import com.dsniatecki.sellyourcar.auction.dto.OwnerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class AuctionCompleteQueryDTO {

    private final Long id;
    private final String title;
    private final Integer price;
    private final CarDTO car;
    private final OwnerDTO owner;
    private final LocationDTO location;
    private final Boolean isPremium;
    private final Integer daysExists;

}
