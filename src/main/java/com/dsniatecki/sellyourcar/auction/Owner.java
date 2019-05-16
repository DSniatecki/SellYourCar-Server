package com.dsniatecki.sellyourcar.auction;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="owners")
class Owner {

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


}
