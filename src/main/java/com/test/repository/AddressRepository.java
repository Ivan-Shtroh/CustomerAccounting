package com.test.repository;

import com.test.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressRepository extends JpaRepository<Address, Long>,
        JpaSpecificationExecutor<Address> {
}
