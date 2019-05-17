package com.dsniatecki.sellyourcar.auction.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class AuctionListItemQueryDTO {

    private final Long id;
    private final String title;
    private final Integer price;
    private final Boolean isPremium;
    private final CarBasicQueryDTO car;

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public AuctionListItemQueryDTO(Long id, String title, Integer price, Boolean isPremium, CarBasicQueryDTO car) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.isPremium = isPremium;
        this.car = car;
    }
}
