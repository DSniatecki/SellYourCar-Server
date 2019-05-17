package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.AuctionListItemQueryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class AuctionCommandService {

    private AuctionRepository auctionRepository;

    AuctionCommandService(AuctionRepository auctionRepository){
        this.auctionRepository = auctionRepository;
    }

}
