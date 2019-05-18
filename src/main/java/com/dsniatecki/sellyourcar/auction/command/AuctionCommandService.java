package com.dsniatecki.sellyourcar.auction.command;

import com.dsniatecki.sellyourcar.auction.command.dto.AuctionCreationCommandDTO;
import com.dsniatecki.sellyourcar.auction.command.dto.AuctionEditionCommandDTO;
import com.dsniatecki.sellyourcar.auction.model.Auction;
import com.dsniatecki.sellyourcar.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class AuctionCommandService {

    private AuctionCommandRepository auctionCommandRepository;

    AuctionCommandService(AuctionCommandRepository auctionCommandRepository){
        this.auctionCommandRepository = auctionCommandRepository;
    }

    void addNew(AuctionCreationCommandDTO auctionDTO) {
        Auction auction = AuctionCommandMapper.mapToAuction(auctionDTO);
        auction.setCreationState();
        auctionCommandRepository.save(auction);
    }

    @Transactional
    public void update(String id, AuctionEditionCommandDTO auctionDTO) {
        Auction auction = auctionCommandRepository.findById(Long.valueOf(id))
                .orElseThrow( () -> new ResourceNotFoundException("Auction[id:"+id+"] was not found.") );
        AuctionCommandMapper.changeAuctionPartly(auction, auctionDTO);
    }

    @Transactional
    public void deleteAuction(String id) {
        auctionCommandRepository.deleteById(Long.valueOf(id));
    }

    @Transactional
    public void activatePremium(String id) {
        if (auctionCommandRepository.existsByIdAndIsPremium(Long.valueOf(id), false))
            auctionCommandRepository.activatePremium(Long.valueOf(id));
        else
            throw new ResourceNotFoundException("Auction[id:"+id+"] was not found, or it is already a premium.");
    }
}
