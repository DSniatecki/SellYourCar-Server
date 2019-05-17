package com.dsniatecki.sellyourcar.auction;


import com.dsniatecki.sellyourcar.auction.dto.AuctionListItemQueryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auctions")
class AuctionQueryController {

    private AuctionQueryService auctionQueryService;

    AuctionQueryController(AuctionQueryService auctionQueryService){
        this.auctionQueryService = auctionQueryService;
    }

    @GetMapping("/all")
    public List<AuctionListItemQueryDTO> getAll(){
        return auctionQueryService.getAll();
    }


}
