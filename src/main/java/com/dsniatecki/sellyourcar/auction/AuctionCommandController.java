package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.model.Auction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auctions")
class AuctionCommandController {

    private AuctionCommandService auctionCommandService;

    AuctionCommandController(AuctionCommandService auctionCommandService){
        this.auctionCommandService = auctionCommandService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    void createAuction(@RequestBody Auction auction){

    }


}
