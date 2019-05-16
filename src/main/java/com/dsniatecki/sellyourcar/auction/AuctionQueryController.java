package com.dsniatecki.sellyourcar.auction;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auctions")
class AuctionQueryController {

    private AuctionCommandService auctionCommandService;

    AuctionQueryController(AuctionCommandService auctionCommandService){
        this.auctionCommandService = auctionCommandService;
    }

}
