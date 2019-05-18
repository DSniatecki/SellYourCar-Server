package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.command.AuctionCreationCommandDTO;
import com.dsniatecki.sellyourcar.auction.dto.command.AuctionEditionCommandDTO;
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
    public void createNew(@RequestBody AuctionCreationCommandDTO auctionDTO){
        auctionCommandService.addNew(auctionDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody AuctionEditionCommandDTO auctionDTO){
        auctionCommandService.update(id, auctionDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        auctionCommandService.deleteAuction(id);
    }

    @PutMapping("/{id}/activate/premium")
    @ResponseStatus(HttpStatus.OK)
    public void activatePremium(@PathVariable String id){
        auctionCommandService.activatePremium(id);
    }

}
