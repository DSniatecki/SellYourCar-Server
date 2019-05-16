package com.dsniatecki.sellyourcar.auction;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auctions")
class AuctionCommandController {

    private AuctionCommandService auctionCommandService;

    AuctionCommandController(AuctionCommandService auctionCommandService){
        this.auctionCommandService = auctionCommandService;
    }


}
