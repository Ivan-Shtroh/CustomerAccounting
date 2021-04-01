package com.test.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
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

    @JsonIgnore
    @NotEmpty
    @Column(name = "created")
    private LocalDateTime created;

    @JsonIgnore
    @NotEmpty
    @Column(name = "modified")
    private LocalDateTime modified;



}
