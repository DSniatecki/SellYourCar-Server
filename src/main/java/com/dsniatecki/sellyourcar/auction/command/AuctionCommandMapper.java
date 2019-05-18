package com.dsniatecki.sellyourcar.auction.command;

import com.dsniatecki.sellyourcar.auction.command.dto.AuctionCreationCommandDTO;
import com.dsniatecki.sellyourcar.auction.command.dto.AuctionEditionCommandDTO;
import com.dsniatecki.sellyourcar.auction.command.dto.CarEditionCommandDTO;
import com.dsniatecki.sellyourcar.auction.command.dto.OwnerEditionCommandDTO;
import com.dsniatecki.sellyourcar.auction.dto.CarDTO;
import com.dsniatecki.sellyourcar.auction.dto.CarDetailsDTO;
import com.dsniatecki.sellyourcar.auction.dto.LocationDTO;
import com.dsniatecki.sellyourcar.auction.dto.OwnerDTO;
import com.dsniatecki.sellyourcar.auction.model.*;

class AuctionCommandMapper {

    private AuctionCommandMapper(){}

    static void changeAuctionPartly(Auction auction, AuctionEditionCommandDTO auctionDTO){
        auction.setTitle(auctionDTO.getTitle());
        auction.setPrice(auctionDTO.getPrice());
        changeCarPartly(auction.getCar(), auctionDTO.getCar());
        changeOwnerPartly(auction.getOwner(), auctionDTO.getOwner());
        changeLocationPartly(auction.getLocation(), auctionDTO.getLocation());
    }

    private static void changeCarPartly(Car car, CarEditionCommandDTO carDTO){
        car.setProductionYear(carDTO.getProductionYear());
        car.setMileage(carDTO.getMileage());
        car.setEnginePower(carDTO.getEnginePower());
        car.setFuelType(carDTO.getFuelType());
        changeCarDetailsPartly(car.getDetails(), carDTO.getCarDetails());
    }

    private static void changeCarDetailsPartly(CarDetails carDetails, CarDetailsDTO carDetailsDTO){
        carDetails.setFeatures(carDetailsDTO.getFeatures());
        carDetails.setDescription(carDetailsDTO.getDescription());
    }

    private static void changeOwnerPartly(Owner owner, OwnerEditionCommandDTO ownerDTO){
        owner.setTelephoneNumber(ownerDTO.getTelephoneNumber());
        owner.setEmail(ownerDTO.getEmail());
    }

    private static void changeLocationPartly(Location location, LocationDTO locationDTO){
        location.setCountry(locationDTO.getCountry());
        location.setProvince(locationDTO.getProvince());
        location.setCity(locationDTO.getCity());
    }

    static Auction mapToAuction(AuctionCreationCommandDTO auctionDTO){
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
