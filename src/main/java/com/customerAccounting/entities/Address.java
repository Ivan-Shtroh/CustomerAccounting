package com.customerAccounting.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

//Сущность адресов
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotEmpty
    @Column(name = "country")
    private String country;

    @NotEmpty
    @Column(name = "region")
    private String region;

    @NotEmpty
    @Column(name = "city")
    private String city;

    @NotEmpty
    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "flat")
    private String flat;

    @NotEmpty
    @Column(name = "created")
    private LocalDateTime created;

    @NotEmpty
    @Column(name = "modified")
    private LocalDateTime modified;

    public Address(@NotEmpty String country, @NotEmpty String region, @NotEmpty String city, @NotEmpty String street) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
    }
}
