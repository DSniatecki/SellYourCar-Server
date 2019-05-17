package com.dsniatecki.sellyourcar.auction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("AuctionRepository - Integartion Test")
class AuctionRepositoryIntegrationTest {

    @Autowired
    private AuctionRepository auctionRepository;

}