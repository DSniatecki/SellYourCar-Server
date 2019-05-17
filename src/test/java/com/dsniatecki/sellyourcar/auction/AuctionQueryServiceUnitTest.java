package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.query.AuctionListItemQueryDTO;
import com.dsniatecki.sellyourcar.auction.model.Auction;
import com.dsniatecki.sellyourcar.auction.tool.TestAuctionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static junit.framework.TestCase.assertSame;
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

    @Test
    @DisplayName("getPage() - SUCCESS")
    void shouldGetPage() {
        Page<Auction> auctionPage = new PageImpl<>(TestAuctionGenerator.generateAuctionList());

        doReturn(auctionPage).when(auctionRepository).findAll(Pageable.unpaged());
        Page<AuctionListItemQueryDTO> returnedAuctionPage = auctionQueryService.getPage(Pageable.unpaged());

        assertAll(
                ()-> assertEquals(returnedAuctionPage.getTotalElements(), 2),
                ()-> assertEquals(returnedAuctionPage.getContent().get(0).getId(),
                        auctionPage.getContent().get(0).getId()),
                ()-> assertEquals(returnedAuctionPage.getContent().get(1).getId(),
                        auctionPage.getContent().get(1).getId()),
                ()-> assertEquals(returnedAuctionPage.getContent().get(0).getIsPremium(),
                        auctionPage.getContent().get(0).getIsPremium()),
                ()-> assertEquals(returnedAuctionPage.getContent().get(0).getPrice(),
                        auctionPage.getContent().get(0).getPrice()),
                ()-> assertEquals(returnedAuctionPage.getContent().get(1).getPrice(),
                        auctionPage.getContent().get(1).getPrice()),
                ()-> assertEquals(returnedAuctionPage.getContent().get(0).getCar().getBrand(),
                        auctionPage.getContent().get(0).getCar().getBrand()),
                ()-> assertEquals(returnedAuctionPage.getContent().get(1).getCar().getModel(),
                        auctionPage.getContent().get(1).getCar().getModel())
        );
    }

}