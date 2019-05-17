package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.AuctionListItemQueryDTO;
import com.dsniatecki.sellyourcar.auction.model.Auction;
import com.dsniatecki.sellyourcar.auction.tool.TestAuctionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("AuctionQueryService - Unit Tests")
class AuctionQueryServiceUnitTest {

    @Autowired
    private AuctionQueryService auctionQueryService;

    @MockBean
    private AuctionRepository auctionRepository;

    @Test
    @DisplayName("getAll() - SUCCESS")
    void shouldGetAllAuctions() {
        List<Auction> auctionList = TestAuctionGenerator.generateAuctionList();
        doReturn(auctionList).when(auctionRepository).findAll();

        List<AuctionListItemQueryDTO> returnedAuctions = auctionQueryService.getAll();

        assertAll(
                ()-> assertEquals(returnedAuctions.get(0).getId(), auctionList.get(0).getId()),
                ()-> assertEquals(returnedAuctions.get(1).getId(), auctionList.get(1).getId()),
                ()-> assertEquals(returnedAuctions.get(0).getIsPremium(), auctionList.get(0).getIsPremium()),
                ()-> assertEquals(returnedAuctions.get(0).getPrice(), auctionList.get(0).getPrice()),
                ()-> assertEquals(returnedAuctions.get(1).getPrice(), auctionList.get(1).getPrice()),
                ()-> assertEquals(returnedAuctions.get(0).getCar().getBrand(), auctionList.get(0).getCar().getBrand()),
                ()-> assertEquals(returnedAuctions.get(1).getCar().getModel(), auctionList.get(1).getCar().getModel())
                );
    }
}