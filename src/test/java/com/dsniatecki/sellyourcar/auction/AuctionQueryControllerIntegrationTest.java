package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.model.Auction;
import com.dsniatecki.sellyourcar.auction.tool.AuctionTestGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(
        properties = {"spring.config.name=myapp-test2-h2","myapp.trx.datasource.url=jdbc:h2:mem:trxServiceStatus"})
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("AuctionQueryController - Integration Tests")
class AuctionQueryControllerIntegrationTest{

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    void prepareDatabaseForTests(){
        auctionRepository.save(AuctionTestGenerator.generateAuction());
    }

    @Test
    @DisplayName("getAll() - SUCCESS")
    void shouldReturnAllAuctions() throws Exception {
        Auction auction = AuctionTestGenerator.generateAuction();

        mockMvc.perform(get("/api/auctions/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(auction.getId()))
                .andExpect(jsonPath("$[0].title").value(auction.getTitle()))
                .andExpect(jsonPath("$[0].price").value(auction.getPrice()))
                .andExpect(jsonPath("$[0].isPremium").value(auction.getIsPremium()))
                .andExpect(jsonPath("$[0].car.brand").value(auction.getCar().getBrand()))
                .andExpect(jsonPath("$[0].car.model").value(auction.getCar().getModel()))
                .andExpect(jsonPath("$[0].car.productionYear").value(auction.getCar().getProductionYear()));
    }

    @Test
    @DisplayName("getPage() - SUCCESS")
    void shouldReturnAuctionPage() throws Exception {
        Auction auction = AuctionTestGenerator.generateAuction();

        mockMvc.perform(get("/api/auctions/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.empty").value(false))
                .andExpect(jsonPath("$.numberOfElements").value(1))
                .andExpect(jsonPath("$.content", hasSize(1)))
                .andExpect(jsonPath("$.content.[0].id").value(auction.getId()))
                .andExpect(jsonPath("$.content.[0].title").value(auction.getTitle()))
                .andExpect(jsonPath("$.content.[0].price").value(auction.getPrice()))
                .andExpect(jsonPath("$.content.[0].isPremium").value(auction.getIsPremium()))
                .andExpect(jsonPath("$.content.[0].car.brand").value(auction.getCar().getBrand()))
                .andExpect(jsonPath("$.content.[0].car.model").value(auction.getCar().getModel()))
                .andExpect(jsonPath("$.content.[0].car.productionYear").value(auction.getCar().getProductionYear()));
    }

    @Test
    @DisplayName("getById() - SUCCESS")
    void shouldReturnAuctionCompleteQueryDTO() throws Exception {
        Auction auction = AuctionTestGenerator.generateAuction();

        mockMvc.perform(get("/api/auctions/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.title").value(auction.getTitle()))
                .andExpect(jsonPath("$.price").value(auction.getPrice()))
                .andExpect(jsonPath("$.car.brand").value(auction.getCar().getBrand()))
                .andExpect(jsonPath("$.car.model").value(auction.getCar().getModel()))
                .andExpect(jsonPath("$.car.enginePower").value(auction.getCar().getEnginePower()))
                .andExpect(jsonPath("$.owner.username").value(auction.getOwner().getUsername()))
                .andExpect(jsonPath("$.owner.telephoneNumber").value(auction.getOwner().getTelephoneNumber()))
                .andExpect(jsonPath("$.owner.email").value(auction.getOwner().getEmail()))
                .andExpect(jsonPath("$.location.country").value(auction.getLocation().getCountry()))
                .andExpect(jsonPath("$.location.province").value(auction.getLocation().getProvince()))
                .andExpect(jsonPath("$.location.city").value(auction.getLocation().getCity()))
                .andExpect(jsonPath("$.isPremium").value(auction.getIsPremium()))
                .andExpect(jsonPath("$.daysExists").value(0));
    }

    @Test
    @DisplayName("getById() - ResourceNotFoundException")
    void shouldReturnAuctionNotFoundExceptionResponse() throws Exception {
        String id="30";
        mockMvc.perform(get("/api/auctions/{id}", id))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.message").value("Auction[id:"+id+"] was not found."))
                .andExpect(jsonPath("$.details").value("uri=/api/auctions/"+id));
    }

}