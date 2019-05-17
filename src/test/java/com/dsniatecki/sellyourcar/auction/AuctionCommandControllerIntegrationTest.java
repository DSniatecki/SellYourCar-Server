package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.command.AuctionCreateCommandDTO;
import com.dsniatecki.sellyourcar.auction.model.Auction;
import com.dsniatecki.sellyourcar.auction.tool.AuctionTestGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        properties = {"spring.config.name=myapp-test1-h2","myapp.trx.datasource.url=jdbc:h2:mem:trxServiceStatus"})
@AutoConfigureMockMvc
@DisplayName("AuctionCommandController - Integration Tests")
class AuctionCommandControllerIntegrationTest {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private AuctionCommandService auctionCommandService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    @DisplayName("createNewAuction() - SUCCESS")
    void shouldCreateNewAuction() throws Exception {
        AuctionCreateCommandDTO auctionDTO = AuctionTestGenerator.generateAuctionCreateCommandDTO();

        mockMvc.perform(post("/api/auctions/")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(convertToJson(auctionDTO))
        )
                .andExpect(status().isCreated());

        Auction savedAuction = auctionRepository.findById(1L).orElseThrow(()->new Exception("Auction not found"));

        assertAll(
                ()-> assertSame(savedAuction.getId(), 1L),
                ()-> assertEquals(savedAuction.getTitle(), auctionDTO.getTitle()),
                ()-> assertEquals(savedAuction.getPrice(), auctionDTO.getPrice()),
                ()-> assertSame(savedAuction.getCar().getId(), 1L),
                ()-> assertEquals(savedAuction.getCar().getBrand(), auctionDTO.getCar().getBrand()),
                ()-> assertEquals(savedAuction.getCar().getModel(), auctionDTO.getCar().getModel()),
                ()-> assertEquals(savedAuction.getCar().getMileage(), auctionDTO.getCar().getMileage()),
                ()-> assertEquals(savedAuction.getCar().getProductionYear(), auctionDTO.getCar().getProductionYear()),
                ()-> assertSame(savedAuction.getCar().getDetails().getId(), 1L),
                ()-> assertEquals(savedAuction.getCar().getDetails().getFeatures(),
                        auctionDTO.getCar().getCarDetails().getFeatures()),
                ()-> assertEquals(savedAuction.getCar().getDetails().getDescription(),
                        auctionDTO.getCar().getCarDetails().getDescription()),
                ()-> assertSame(savedAuction.getOwner().getId(), 1L),
                ()-> assertEquals(savedAuction.getOwner().getUsername(), auctionDTO.getOwner().getUsername()),
                ()-> assertEquals(savedAuction.getOwner().getTelephoneNumber(),
                        auctionDTO.getOwner().getTelephoneNumber()),
                ()-> assertEquals(savedAuction.getOwner().getEmail(), auctionDTO.getOwner().getEmail()),
                ()-> assertSame(savedAuction.getLocation().getId(), 1L),
                ()-> assertEquals(savedAuction.getLocation().getCountry(), auctionDTO.getLocation().getCountry()),
                ()-> assertEquals(savedAuction.getLocation().getProvince(), auctionDTO.getLocation().getProvince()),
                ()-> assertEquals(savedAuction.getLocation().getCity(), auctionDTO.getLocation().getCity()),
                ()-> assertSame(savedAuction.getIsPremium(), false),
                ()-> assertSame(savedAuction.getDaysExists(), 0)
        );
    }

    private String convertToJson(Object object){
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }

    }
}