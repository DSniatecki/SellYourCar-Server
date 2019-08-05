package com.dsniatecki.sellyourcar.auction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
public final class OwnerDTO {

    @Size(min = 4, max = 40, message = "About Me must be between 4 and 40 characters")
    private final String username;

    @Size(min = 8, max = 12, message = "About Me must be between 8 and 12 characters")
    private final String telephoneNumber;

    @Email
    @Size(min = 5, max = 80, message = "About Me must be between 5 and 80 characters")
    private final String email;

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public OwnerDTO(@JsonProperty("username") String username,
                    @JsonProperty("telephoneNumber") String telephoneNumber,
                    @JsonProperty("email") String email) {
        this.username = username;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

}
