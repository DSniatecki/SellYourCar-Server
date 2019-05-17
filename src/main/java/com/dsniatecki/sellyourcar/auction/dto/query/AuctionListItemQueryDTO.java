package com.dsniatecki.sellyourcar.auction.dto.query;


import lombok.Getter;

@Getter
public class AuctionListItemQueryDTO {

    private final Long id;
    private final String title;
    private final Integer price;
    private final Boolean isPremium;
    private final CarBasicQueryDTO car;

    public AuctionListItemQueryDTO(Long id, String title, Integer price, Boolean isPremium, CarBasicQueryDTO car) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.isPremium = isPremium;
        this.car = car;
    }
}
