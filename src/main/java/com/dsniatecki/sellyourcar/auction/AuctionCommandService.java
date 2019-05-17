package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.command.AuctionCreateCommandDTO;
import com.dsniatecki.sellyourcar.auction.model.Auction;
import org.springframework.stereotype.Service;

@Service
class AuctionCommandService {

    private AuctionRepository auctionRepository;

    AuctionCommandService(AuctionRepository auctionRepository){
        this.auctionRepository = auctionRepository;
    }

    void addNew(AuctionCreateCommandDTO auctionDTO) {
        Auction auction = AuctionCommandMapper.mapToAuction(auctionDTO);
        auction.setCreationState();
        auctionRepository.save(auction);
    }
}
