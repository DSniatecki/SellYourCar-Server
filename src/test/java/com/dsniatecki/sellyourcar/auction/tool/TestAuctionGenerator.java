package com.dsniatecki.sellyourcar.auction.tool;

import com.dsniatecki.sellyourcar.auction.model.*;

import java.util.Arrays;
import java.util.List;

public class TestAuctionGenerator {

    private TestAuctionGenerator(){}

    public static Auction generateAuction(){
        return Auction.builder()
                .id(1L)
                .title("Test Auction")
                .price(10_000)
                .car(Car.builder()
                        .id(2L)
                        .brand("Test Brand")
                        .model("Test Model")
                        .productionYear(2019)
                        .mileage(100_000)
                        .enginePower(100)
                        .fuelType("Test FuelType")
                        .details(new CarDetails(
                                3L,
                                "Test Features",
                                "Test Description"))
                        .build()
                )
                .location(new Location(4L,
                        "Test Country",
                        "Test Province",
                        "Test City" ))
                .owner(new Owner(5L,
                        "Test Username",
                        "Test TelephoneNumber",
                        "Test Email"))
                .isPremium(false)
                .isDeleted(false)
                .build();

    }

    public static List<Auction> generateAuctionList(){
        return Arrays.asList(
                Auction.builder()
                        .id(1L)
                        .title("FirstTile")
                        .price(1)
                        .isPremium(false)
                        .car(Car.builder()
                            .brand("FirstCarBrand")
                            .model("FirstCarModel")
                            .productionYear(2000)
                            .build()
                        )
                        .build(),
                Auction.builder()
                        .id(2L)
                        .title("SecondTile")
                        .price(2)
                        .isPremium(false)
                        .car(Car.builder()
                                .brand("SecondCarBrand")
                                .model("SecondCarModel")
                                .productionYear(2010)
                                .build()
                        )
                        .build()
        );
    }


}
