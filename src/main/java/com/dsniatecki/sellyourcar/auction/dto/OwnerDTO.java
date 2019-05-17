package com.dsniatecki.sellyourcar.auction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class OwnerDTO {

    private final String username;
    private final String telephoneNumber;
    private final String email;

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public OwnerDTO(String username, String telephoneNumber, String email) {
        this.username = username;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }
}
