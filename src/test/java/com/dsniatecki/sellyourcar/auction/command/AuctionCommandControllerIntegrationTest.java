package com.dsniatecki.sellyourcar.auction.command;

import com.dsniatecki.sellyourcar.auction.command.dto.AuctionCreationCommandDTO;
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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        properties = {"spring.config.name=myapp-test1-h2","myapp.trx.datasource.url=jdbc:h2:mem:trxServiceStatus"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@DisplayName("AuctionCommandController - Integration Tests")
class AuctionCommandControllerIntegrationTest {

    @Autowired
    private AuctionCommandRepository auctionCommandRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    @DisplayName("createNewAuction() - SUCCESS")
    void shouldCreateNew() throws Exception {
        AuctionCreationCommandDTO auctionDTO = AuctionTestGenerator.generateAuctionCreateCommandDTO();

        mockMvc.perform(post("/api/auctions/")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(convertToJson(auctionDTO))
        )
                .andExpect(status().isCreated());
        Auction savedAuction = auctionCommandRepository.findById(1L)
                                        .orElseThrow(()->new Exception("Auction not found"));

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

    @Test
    @Transactional
    @DisplayName("update() - SUCCESS")
    void shouldUpdatePartly() throws Exception {
        Auction auction = AuctionTestGenerator.generateAuction();
        auction.getCar().setBrand("Brand should not change");
        auction.getCar().setModel("Model should not change");
        auction.getOwner().setUsername("Username should not change");

        Auction previousAuction = auctionCommandRepository.save(auction);

        AuctionCreationCommandDTO auctionDTO = AuctionTestGenerator.generateAuctionCreateCommandDTO();

        mockMvc.perform(put("/api/auctions/{id}", previousAuction.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(convertToJson(auctionDTO))
        )
                .andExpect(status().isOk());

        Auction updatedAuction = auctionCommandRepository.findById(previousAuction.getId())
                                                .orElseThrow(()->new Exception("Auction not found"));

        assertAll(
                ()-> assertSame(updatedAuction.getId(), previousAuction.getId()),
                ()-> assertEquals(updatedAuction.getTitle(), auctionDTO.getTitle()),
                ()-> assertEquals(updatedAuction.getPrice(), auctionDTO.getPrice()),
                ()-> assertSame(updatedAuction.getCar().getId(), previousAuction.getCar().getId()),
                ()-> assertEquals(updatedAuction.getCar().getBrand(), previousAuction.getCar().getBrand()),
                ()-> assertEquals(updatedAuction.getCar().getModel(), previousAuction.getCar().getModel()),
                ()-> assertEquals(updatedAuction.getCar().getMileage(), auctionDTO.getCar().getMileage()),
                ()-> assertEquals(updatedAuction.getCar().getProductionYear(), auctionDTO.getCar().getProductionYear()),
                ()-> assertSame(updatedAuction.getCar().getDetails().getId(),
                        previousAuction.getCar().getDetails().getId()),
                ()-> assertEquals(updatedAuction.getCar().getDetails().getFeatures(),
                        auctionDTO.getCar().getCarDetails().getFeatures()),
                ()-> assertEquals(updatedAuction.getCar().getDetails().getDescription(),
                        auctionDTO.getCar().getCarDetails().getDescription()),
                ()-> assertSame(updatedAuction.getOwner().getId(), previousAuction.getOwner().getId()),
                ()-> assertEquals(updatedAuction.getOwner().getUsername(), previousAuction.getOwner().getUsername()),
                ()-> assertEquals(updatedAuction.getOwner().getTelephoneNumber(),
                        auctionDTO.getOwner().getTelephoneNumber()),
                ()-> assertEquals(updatedAuction.getOwner().getEmail(), auctionDTO.getOwner().getEmail()),
                ()-> assertSame(updatedAuction.getLocation().getId(), previousAuction.getLocation().getId()),
                ()-> assertEquals(updatedAuction.getLocation().getCountry(), auctionDTO.getLocation().getCountry()),
                ()-> assertEquals(updatedAuction.getLocation().getProvince(), auctionDTO.getLocation().getProvince()),
                ()-> assertEquals(updatedAuction.getLocation().getCity(), auctionDTO.getLocation().getCity()),
                ()-> assertSame(updatedAuction.getIsPremium(), false),
                ()-> assertSame(updatedAuction.getDaysExists(), 0)
        );
    }

    @Test
    @Transactional
    @DisplayName("delete() - SUCCESS")
    public void shouldDelete() throws Exception {
        Auction savedAuction = auctionCommandRepository.save(AuctionTestGenerator.generateAuction());

        mockMvc.perform(delete("/api/auctions/{id}", savedAuction.getId()))
                .andExpect(status().isOk());

        boolean exists = auctionCommandRepository.existsById(savedAuction.getId());

        assertSame(exists, false);
    }

    private String convertToJson(Object object){
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }

    }

}