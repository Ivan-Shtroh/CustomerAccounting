package com.test.servise;

import com.test.entities.Customer;
import com.test.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    CustomerRepository customerRepository;
    @Autowired
    public void setCustomerRepository( CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer customer) {customerRepository.save(customer);}

    @Override
    public Page<Customer> getAllBySpecification(Specification<Customer> spec, Pageable pageable) { return customerRepository.findAll(spec, pageable);}

    @Override
    public void delete(Customer customer) { customerRepository.delete(customer);}

    @Override
    public Customer getOne(Long id) {
        return customerRepository.getOne(id);
    }


}
