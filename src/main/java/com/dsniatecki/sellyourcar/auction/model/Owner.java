package com.dsniatecki.sellyourcar.auction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="telephone_number")
    private String telephoneNumber;

    @Column(name="email")
    private String email;

    public Owner(String username, String telephoneNumber, String email) {
        this.username = username;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }
}
