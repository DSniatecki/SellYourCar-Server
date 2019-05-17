package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.query.AuctionCompleteQueryDTO;
import com.dsniatecki.sellyourcar.auction.dto.query.AuctionListItemQueryDTO;
import com.dsniatecki.sellyourcar.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .map(AuctionQueryMapper::mapToListItemQueryDTO)
                .collect(Collectors.toList());
    }

    Page<AuctionListItemQueryDTO> getPage(Pageable pageRequest){
        return auctionRepository.findAll(pageRequest)
                .map(AuctionQueryMapper::mapToListItemQueryDTO);
    }

    @Transactional(readOnly = true)
    public AuctionCompleteQueryDTO getById(String id) {
        return auctionRepository.findById(Long.valueOf(id))
                .map(AuctionQueryMapper::mapToCompleteQueryDTO)
                .orElseThrow( () -> new ResourceNotFoundException("Auction[id:" + id + "] was not found.") );
    }

}
