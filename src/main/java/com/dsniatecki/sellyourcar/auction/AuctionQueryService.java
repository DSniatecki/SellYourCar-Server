package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.AuctionListItemQueryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class AuctionQueryService {

    private AuctionRepository auctionRepository;

    AuctionQueryService(AuctionRepository auctionRepository){
        this.auctionRepository = auctionRepository;
    }

    List<AuctionListItemQueryDTO> getAll() {
        return auctionRepository.findAll().stream()
                .map(AuctionMapper::fromAuction)
                .collect(Collectors.toList());
    }

}
