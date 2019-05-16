package com.dsniatecki.sellyourcar.auction;

import org.springframework.stereotype.Service;

@Service
class AuctionQueryService {

    private AuctionRepository auctionRepository;

    AuctionQueryService(AuctionRepository auctionRepository){
        this.auctionRepository = auctionRepository;
    }


}
