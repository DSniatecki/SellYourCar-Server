package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.query.AuctionCompleteQueryDTO;
import com.dsniatecki.sellyourcar.auction.dto.query.AuctionListItemQueryDTO;
import com.dsniatecki.sellyourcar.auction.exceptions.AuctionNotFoundException;
import com.dsniatecki.sellyourcar.auction.model.Auction;
import com.dsniatecki.sellyourcar.auction.tool.AuctionTestGenerator;
import org.junit.jupiter.api.Assertions;
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
import java.util.Optional;

import static junit.framework.TestCase.assertSame;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
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
        List<Auction> auctionList = AuctionTestGenerator.generateAuctionList();
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
        Page<Auction> auctionPage = new PageImpl<>(AuctionTestGenerator.generateAuctionList());
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

    @Test
    @DisplayName("getById() - SUCCESS")
    void shouldGetById() {
        Auction auction = AuctionTestGenerator.generateAuction();
        doReturn(Optional.ofNullable(auction)).when(auctionRepository).findById(anyLong());

        AuctionCompleteQueryDTO returnedAuctionDTO = auctionQueryService.getById("1");

        assertAll(
                ()-> assertEquals(returnedAuctionDTO.getId(), auction.getId()),
                ()-> assertEquals(returnedAuctionDTO.getTitle(), auction.getTitle()),
                ()-> assertEquals(returnedAuctionDTO.getPrice(), auction.getPrice()),
                ()-> assertEquals(returnedAuctionDTO.getCar().getBrand(), auction.getCar().getBrand()),
                ()-> assertEquals(returnedAuctionDTO.getCar().getModel(), auction.getCar().getModel()),
                ()-> assertEquals(returnedAuctionDTO.getOwner().getUsername(), auction.getOwner().getUsername()),
                ()-> assertEquals(returnedAuctionDTO.getLocation().getCountry(), auction.getLocation().getCountry()),
                ()-> assertEquals(returnedAuctionDTO.getLocation().getCity(), auction.getLocation().getCity()),
                ()-> assertEquals(returnedAuctionDTO.getIsPremium(), auction.getIsPremium()),
                ()-> assertEquals(returnedAuctionDTO.getDaysExists(), auction.getDaysExists())
        );
    }

    @Test
    @DisplayName("getById() - FAILED: AuctionNotFoundException")
    void shouldNotGetById(){
        doReturn(Optional.empty()).when(auctionRepository).findById(anyLong());

        AuctionNotFoundException exception = assertThrows(
                AuctionNotFoundException.class, ()-> auctionQueryService.getById("1")
        );

        Assertions.assertEquals(exception.getMessage(), "Auction[id:1] was not found.");
    }

}