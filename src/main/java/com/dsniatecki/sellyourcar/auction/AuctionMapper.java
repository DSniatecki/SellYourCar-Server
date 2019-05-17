package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.AuctionListItemQueryDTO;
import com.dsniatecki.sellyourcar.auction.dto.CarBasicQueryDTO;
import com.dsniatecki.sellyourcar.auction.model.Auction;

class AuctionMapper {

    private AuctionMapper(){}

    static AuctionListItemQueryDTO fromAuction(Auction auction){
        return new AuctionListItemQueryDTO(
                auction.getId(),
                auction.getTitle(),
                auction.getPrice(),
                auction.getIsPremium(),
                new CarBasicQueryDTO(
                        auction.getCar().getBrand(),
                        auction.getCar().getModel(),
                        auction.getCar().getProductionYear()
                )
        );

    }

}
