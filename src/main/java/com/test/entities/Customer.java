package com.test.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;


    @ManyToOne(optional = false)
    @JoinColumn(name = "registered_address_id", nullable = false)
    private Address registeredAddress;

    @ManyToOne(optional = false)
    @JoinColumn(name = "actual_address_id", nullable = false)
    private Address actualAddress;

    @NotEmpty
    @Pattern(regexp = "male|female", message = "Should be \"male\" or \"female\".")
    @Size(max = 6)
    private String sex;



}
