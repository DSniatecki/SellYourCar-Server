package com.dsniatecki.sellyourcar.auction.command;

import com.dsniatecki.sellyourcar.auction.command.dto.AuctionCreationCommandDTO;
import com.dsniatecki.sellyourcar.auction.command.dto.AuctionEditionCommandDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/auctions")
class AuctionCommandController {

    private AuctionCommandService auctionCommandService;

    AuctionCommandController(AuctionCommandService auctionCommandService){
        this.auctionCommandService = auctionCommandService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNew(@Valid @RequestBody AuctionCreationCommandDTO auctionDTO){
        auctionCommandService.addNew(auctionDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody AuctionEditionCommandDTO auctionDTO, @PathVariable String id){
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
