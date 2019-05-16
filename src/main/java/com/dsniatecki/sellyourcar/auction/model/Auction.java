package com.dsniatecki.sellyourcar.auction.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.MINUTES;

@Data
@Builder
@Entity
@Table(name="auctions")
@Where(clause = "is_deleted=false")
@SQLDelete(sql="update auctions set is_deleted=true where id=?")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="car_id")
    private Car car;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="location_id")
    private Location location;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="owner_id")
    private Owner owner;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="details_id")
    private Details details;

    @Column(name="is_premium")
    private Boolean isPremium;

    @Column(name="is_deleted")
    private Boolean isDeleted;

    @Column(name="creation_date")
    private LocalDateTime creationDate;

    @Column(name="creation_date")
    private LocalDateTime modificationDate;

    private Long existDays;

    public Long getExistDays(){
        return MINUTES.between(creationDate, LocalDateTime.now());
    }

}
