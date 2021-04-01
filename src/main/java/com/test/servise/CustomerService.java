package com.test.servise;

import com.test.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface CustomerService {

    void save(Customer customer);

    Page<Customer> getAllBySpecification(Specification<Customer> spec, Pageable pageable);

    void delete(Customer customer);

    Customer getOne(Long id);


}
