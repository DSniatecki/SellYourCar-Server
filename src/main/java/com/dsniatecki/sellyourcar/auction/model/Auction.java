package com.dsniatecki.sellyourcar.auction.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.MINUTES;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name="auctions")
@Where(clause = "is_deleted=false")
@SQLDelete(sql="UPDATE Auctions SET is_deleted=true WHERE id=?")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private Integer price;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name="car_id")
    private Car car;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name="location_id")
    private Location location;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name="owner_id")
    private Owner owner;

    @Column(name="is_premium")
    private Boolean isPremium;

    @Column(name="is_deleted")
    private Boolean isDeleted;

    @Column(name="creation_date")
    private LocalDateTime creationDate;

    @Column(name="modification_date")
    private LocalDateTime modificationDate;

    @Transient
    private Long existsDays;

    public Auction() {

    }

    @PrePersist
    private void setCreationDate(){
       if(creationDate==null)
           creationDate = LocalDateTime.now();
       else
           modificationDate = LocalDateTime.now();
    }

    @PreUpdate
    private void setModificationDate(){
        modificationDate = LocalDateTime.now();
    }

    public Long getExistsDays(){
        return MINUTES.between(creationDate, LocalDateTime.now());
    }

}
