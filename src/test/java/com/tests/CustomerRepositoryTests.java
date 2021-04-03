package com.tests;

import com.customerAccounting.entities.Address;
import com.customerAccounting.entities.Customer;
import com.customerAccounting.repository.AddressRepository;
import com.customerAccounting.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CustomerRepository customerRepository;


    @Test
    public void testSaveNewCustomer() {

        Address address = new Address("russia", "moscow", "moscow", "tverskaya");
        address.setCreated(LocalDateTime.now());
        address.setModified(LocalDateTime.now());
        entityManager.persist(address);

        Customer customer = new Customer(address, address, "ivan", "ivanov", "ivanovich", "male");
        entityManager.persist(customer);
        customer = customerRepository.getOne(1L);
        assertThat(customer.getFirstName().equals("ivan"));

    }

    @Test
    public void testUpdateCustomer() {
        Address address = new Address("russia", "moscow", "moscow", "tverskaya");
        address.setCreated(LocalDateTime.now());
        address.setModified(LocalDateTime.now());
        entityManager.persist(address);

        Customer customer = new Customer(address, address, "ivan", "ivanov", "ivanovich", "male");
        entityManager.persist(customer);

        customer.setFirstName("vladimir");
        customerRepository.save(customer);

        Customer updatedCustomer =customerRepository.findByLastName("ivanov");

        assertThat(updatedCustomer.getFirstName()).isEqualTo("vladimir");


    }

    @Test
    public void testDeleteCustomer(){

        Address address = new Address("russia", "moscow", "moscow", "tverskaya");
        address.setCreated(LocalDateTime.now());
        address.setModified(LocalDateTime.now());
        entityManager.persist(address);

        Customer customer = new Customer(address, address, "ivan", "ivanov", "ivanovich", "male");
        entityManager.persist(customer);

        customerRepository.delete(customer);
        Customer deletedCustomer = customerRepository.findByFirstName("ivan");

        assertThat(deletedCustomer).isNull();

    }


}
