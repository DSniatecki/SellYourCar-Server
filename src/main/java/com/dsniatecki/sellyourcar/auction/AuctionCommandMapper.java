package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.CarDTO;
import com.dsniatecki.sellyourcar.auction.dto.CarDetailsDTO;
import com.dsniatecki.sellyourcar.auction.dto.LocationDTO;
import com.dsniatecki.sellyourcar.auction.dto.OwnerDTO;
import com.dsniatecki.sellyourcar.auction.dto.command.AuctionCreateCommandDTO;
import com.dsniatecki.sellyourcar.auction.model.*;

class AuctionCommandMapper {

    private AuctionCommandMapper(){}

    static Auction mapToAuction(AuctionCreateCommandDTO auctionDTO){
        return Auction.builder()
                .title(auctionDTO.getTitle())
                .price(auctionDTO.getPrice())
                .car(mapToCar(auctionDTO.getCar()))
                .owner(mapToOwner(auctionDTO.getOwner()))
                .location(mapToLocation(auctionDTO.getLocation()))
                .build();
    }

    private static Car mapToCar(CarDTO carDTO){
        return Car.builder()
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .productionYear(carDTO.getProductionYear())
                .mileage(carDTO.getMileage())
                .enginePower(carDTO.getEnginePower())
                .fuelType(carDTO.getFuelType())
                .details(mapToCarDetails(carDTO.getCarDetails()))
                .build();

    }

    private static CarDetails mapToCarDetails(CarDetailsDTO carDetailsDTO){
        return new CarDetails(
                carDetailsDTO.getFeatures(),
                carDetailsDTO.getDescription()
        );
    }

    private static Owner mapToOwner(OwnerDTO ownerDTO){
        return new Owner(
                ownerDTO.getUsername(),
                ownerDTO.getTelephoneNumber(),
                ownerDTO.getEmail()
        );
    }

    private static Location mapToLocation(LocationDTO locationDTO){
        return new Location(
                locationDTO.getCountry(),
                locationDTO.getProvince(),
                locationDTO.getCity()
        );
    }

}
