package com.dsniatecki.sellyourcar.auction;

import com.dsniatecki.sellyourcar.auction.dto.CarDTO;
import com.dsniatecki.sellyourcar.auction.dto.CarDetailsDTO;
import com.dsniatecki.sellyourcar.auction.dto.LocationDTO;
import com.dsniatecki.sellyourcar.auction.dto.OwnerDTO;
import com.dsniatecki.sellyourcar.auction.dto.query.AuctionListItemQueryDTO;
import com.dsniatecki.sellyourcar.auction.dto.query.AuctionCompleteQueryDTO;
import com.dsniatecki.sellyourcar.auction.dto.query.CarBasicQueryDTO;
import com.dsniatecki.sellyourcar.auction.model.*;

class AuctionMapper {

    private AuctionMapper(){}

    static AuctionListItemQueryDTO mapToListItemQueryDTO(Auction auction){
        return new AuctionListItemQueryDTO(
                auction.getId(),
                auction.getTitle(),
                auction.getPrice(),
                auction.getIsPremium(),
                new CarBasicQueryDTO(
                        auction.getCar().getBrand(),
                        auction.getCar().getModel(),
                        auction.getCar().getProductionYear()
                )
        );
    }

    static AuctionCompleteQueryDTO mapToCompleteQueryDTO(Auction auction) {
        return new AuctionCompleteQueryDTO(
                auction.getId(),
                auction.getTitle(),
                auction.getPrice(),
                mapToCarDTO(auction.getCar()),
                mapToOwnerDTO(auction.getOwner()),
                mapToLocationDTO(auction.getLocation()),
                auction.getIsPremium(),
                auction.getDaysExists()

        );
    }

    private static CarDetailsDTO mapToCarDetailsDTO(CarDetails carDetails){
        return new CarDetailsDTO(
                carDetails.getFeatures(),
                carDetails.getDescription()
        );
    }


    private static CarDTO mapToCarDTO(Car car){
        return new CarDTO(
                car.getBrand(),
                car.getModel(),
                car.getProductionYear(),
                car.getMileage(),
                car.getEnginePower(),
                car.getFuelType(),
                mapToCarDetailsDTO(car.getDetails())
        );
    }

    private static OwnerDTO mapToOwnerDTO(Owner owner){
        return new OwnerDTO(
                owner.getUsername(),
                owner.getTelephoneNumber(),
                owner.getEmail()
        );
    }

    private static LocationDTO mapToLocationDTO(Location location){
        return new LocationDTO(
                location.getCountry(),
                location.getProvince(),
                location.getCity()
        );
    }

}
