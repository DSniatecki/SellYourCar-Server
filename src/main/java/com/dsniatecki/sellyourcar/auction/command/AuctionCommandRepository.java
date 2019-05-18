package com.dsniatecki.sellyourcar.auction.command;

import com.dsniatecki.sellyourcar.auction.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface AuctionCommandRepository extends JpaRepository<Auction, Long> {

    boolean existsById(Long id);
    boolean existsByIdAndIsPremium(Long id, boolean isPremium);

    @Modifying
    @Query("UPDATE Auction a SET a.isPremium=true WHERE a.id=:id AND a.isPremium=false")
    void activatePremium(@Param("id") Long id);

}