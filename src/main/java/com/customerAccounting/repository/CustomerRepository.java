package com.customerAccounting.repository;

import com.customerAccounting.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerRepository extends JpaRepository<Customer, Long>,
        JpaSpecificationExecutor<Customer> {
    Page<Customer> findAll(Specification<Customer> spec, Pageable pageable);
    Customer findByFirstName(String firstName);
    Customer findByLastName(String lastName);


}
