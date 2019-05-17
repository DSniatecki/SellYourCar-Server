package com.dsniatecki.sellyourcar.auction.dto.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class CarBasicQueryDTO {

    private final String brand;
    private final String model;
    private final Integer productionYear;

}
