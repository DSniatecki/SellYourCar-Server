package com.dsniatecki.sellyourcar.auction;

import org.springframework.stereotype.Service;

@Service
class AuctionCommandService {

    private AuctionRepository auctionRepository;

    AuctionCommandService(AuctionRepository auctionRepository){
        this.auctionRepository = auctionRepository;
    }

}
