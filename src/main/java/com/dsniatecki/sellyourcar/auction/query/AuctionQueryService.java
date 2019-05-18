package com.dsniatecki.sellyourcar.auction.query;

import com.dsniatecki.sellyourcar.auction.query.dto.AuctionCompleteQueryDTO;
import com.dsniatecki.sellyourcar.auction.query.dto.AuctionListItemQueryDTO;
import com.dsniatecki.sellyourcar.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
class AuctionQueryService {

    private AuctionQueryRepository auctionQueryRepository;

    AuctionQueryService(AuctionQueryRepository auctionQueryRepository){
        this.auctionQueryRepository = auctionQueryRepository;
    }

    List<AuctionListItemQueryDTO> getAll() {
        return auctionQueryRepository.findAll().stream()
                .map(AuctionQueryMapper::mapToListItemQueryDTO)
                .collect(Collectors.toList());
    }

    Page<AuctionListItemQueryDTO> getPage(Pageable pageRequest){
        return auctionQueryRepository.findAll(pageRequest)
                .map(AuctionQueryMapper::mapToListItemQueryDTO);
    }

    Page<AuctionListItemQueryDTO> getPageBy(String word, Pageable pageRequest) {
        return auctionQueryRepository.findAllByWord(word, pageRequest)
                .map(AuctionQueryMapper::mapToListItemQueryDTO);
    }

    @Transactional(readOnly = true)
    public AuctionCompleteQueryDTO getById(String id) {
        return auctionQueryRepository.findById(Long.valueOf(id))
                .map(AuctionQueryMapper::mapToCompleteQueryDTO)
                .orElseThrow( () -> new ResourceNotFoundException("Auction[id:" + id + "] was not found.") );
    }
}
