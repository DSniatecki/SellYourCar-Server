package com.dsniatecki.sellyourcar.auction.dto.query;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class AuctionListItemQueryDTO {

    private final Long id;
    private final String title;
    private final Integer price;
    private final Boolean isPremium;
    private final CarBasicQueryDTO car;

}
