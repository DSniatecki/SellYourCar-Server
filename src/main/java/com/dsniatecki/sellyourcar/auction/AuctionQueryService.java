package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.query.AuctionListItemQueryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    Page<AuctionListItemQueryDTO> getPage(Pageable pageRequest){
        return auctionRepository.findAll(pageRequest)
                .map(AuctionMapper::fromAuction);
    }
}
