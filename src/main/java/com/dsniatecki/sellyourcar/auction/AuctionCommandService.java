package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.command.AuctionCreationCommandDTO;
import com.dsniatecki.sellyourcar.auction.dto.command.AuctionEditionCommandDTO;
import com.dsniatecki.sellyourcar.auction.model.Auction;
import com.dsniatecki.sellyourcar.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class AuctionCommandService {

    private AuctionRepository auctionRepository;

    AuctionCommandService(AuctionRepository auctionRepository){
        this.auctionRepository = auctionRepository;
    }

    void addNew(AuctionCreationCommandDTO auctionDTO) {
        Auction auction = AuctionCommandMapper.mapToAuction(auctionDTO);
        auction.setCreationState();
        auctionRepository.save(auction);
    }

    @Transactional
    public void update(String id, AuctionEditionCommandDTO auctionDTO) {
        Auction auction = auctionRepository.findById(Long.valueOf(id))
                .orElseThrow( () -> new ResourceNotFoundException("Auction[id:"+id+"] was not found.") );
        AuctionCommandMapper.changeAuctionPartly(auction, auctionDTO);
    }

    @Transactional
    public void deleteAuction(String id) {
        auctionRepository.deleteById(Long.valueOf(id));
    }

    @Transactional
    public void activatePremium(String id) {
        if (auctionRepository.existsByIdAndIsPremiumIs(Long.valueOf(id), false))
            auctionRepository.activatePremium(Long.valueOf(id));
        else
            throw new ResourceNotFoundException("Auction[id:"+id+"] was not found, or it is already a premium.");
    }
}
