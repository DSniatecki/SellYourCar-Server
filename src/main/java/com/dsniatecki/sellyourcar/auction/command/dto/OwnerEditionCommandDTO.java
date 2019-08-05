package com.dsniatecki.sellyourcar.auction.command.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
public final class OwnerEditionCommandDTO {

    @Size(min = 8, max = 12, message = "About Me must be between 8 and 12 characters")
    private final String telephoneNumber;

    @Email
    @Size(min = 5, max = 80, message = "About Me must be between 5 and 80 characters")
    private final String email;

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public OwnerEditionCommandDTO(@JsonProperty("telephoneNumber") String telephoneNumber,
                    @JsonProperty("email") String email) {
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }
}
