package com.dsniatecki.sellyourcar.auction.query;

import com.dsniatecki.sellyourcar.auction.model.Auction;
import com.dsniatecki.sellyourcar.auction.query.dto.AuctionListItemQueryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AuctionQueryRepository extends JpaRepository<Auction, Long> {

    Page<Auction> findAllByTitleContainingOrCarBrandContainingOrCarModelContaining(String title, String brand,
                                                               String model, Pageable pageRequest);

    default Page<Auction> findAllByWord(String word, Pageable pageRequest){
        return findAllByTitleContainingOrCarBrandContainingOrCarModelContaining(word, word, word, pageRequest);
    }
}
