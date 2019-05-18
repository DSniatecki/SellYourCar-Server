package com.dsniatecki.sellyourcar.auction.command.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public final class OwnerEditionCommandDTO {

    private final String telephoneNumber;
    private final String email;

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public OwnerEditionCommandDTO(@JsonProperty("telephoneNumber") String telephoneNumber,
                    @JsonProperty("email") String email) {
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }
}
