package com.tests;

import com.customerAccounting.entities.Address;
import com.customerAccounting.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AddressRepositoryTests {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    AddressRepository addressRepository;

    @Test
    public void testSaveNewAddress() {
        Address address = new Address("russia", "moscow", "moscow", "tverskaya");
        address.setCreated(LocalDateTime.now());
        address.setModified(LocalDateTime.now());
        entityManager.persist(address);

        address = addressRepository.findByCity("moscow");

        assertThat(address.getCountry()).isEqualTo("russia");
    }

    @Test
    public void testUpdateAddress(){
        Address address = new Address("russia", "moscow", "moscow", "tverskaya");
        address.setCreated(LocalDateTime.now());
        address.setModified(LocalDateTime.now());
        entityManager.persist(address);

        address.setCity("St. Petersburg");
        addressRepository.save(address);

        Address updatedAddress = addressRepository.findByCity("St. Petersburg");

        assertThat(updatedAddress.getCity()).isEqualTo("St. Petersburg");

    }

    @Test
    public void testDeleteAddress() {
        Address address = new Address("russia", "moscow", "moscow", "tverskaya");
        address.setCreated(LocalDateTime.now());
        address.setModified(LocalDateTime.now());
        entityManager.persist(address);

        addressRepository.delete(address);

        Address deletedAddress = addressRepository.findByCity("moscow");

        assertThat(deletedAddress).isNull();

    }




}
