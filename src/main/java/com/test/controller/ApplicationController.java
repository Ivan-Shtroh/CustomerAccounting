package com.test.controller;

import com.test.entities.Address;
import com.test.entities.Customer;
import com.test.servise.AddressService;
import com.test.servise.CustomerService;
import com.test.specification.CustomerSpecification;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Getter
@Setter
public class ApplicationController {
    CustomerService customerService;
    AddressService addressService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     *
     * @param firstName - фамилия клиента (параметр фильтрации)
     * @param lastName - имя клиента (параметр фильтрации)
     * @param pageable - характеристики страницы по умолчанию
     * @return - список клиентов
     */
    @GetMapping("/show_customers")
    public ResponseEntity<?> getAll(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @PageableDefault(page = 0, size = 15) Pageable pageable
    ) {
        Customer filter = new Customer();
        filter.setFirstName(firstName);
        filter.setLastName(lastName);

        Page<Customer> page = customerService.getAllBySpecification(new CustomerSpecification(filter), pageable);
        return ResponseEntity.ok(page.get().collect(Collectors.toList()));
    }

    /**
     *
     * @param customer
     * @return
     */
    @PostMapping("/create_customer")
    public ResponseEntity<?> createCustomer(
            @RequestBody @Valid Customer customer) {

        Address actualAddress = customer.getActualAddress();
        actualAddress.setCreated(LocalDateTime.now());
        actualAddress.setModified(LocalDateTime.now());
        addressService.save(actualAddress);

        Address registeredAddress = customer.getRegisteredAddress();
        registeredAddress.setCreated(LocalDateTime.now());
        registeredAddress.setModified(LocalDateTime.now());
        addressService.save(registeredAddress);
        customer.setActualAddress(actualAddress);
        customer.setRegisteredAddress(registeredAddress);
        customerService.save(customer);

        return ResponseEntity.ok(customer);
    }

    /**
     *
     * @return -
     */
    @PutMapping("/change_customer")
    public ResponseEntity<?> updateCustomer(@RequestBody @Valid Customer customer) {

        customerService.save(customer);
        return ResponseEntity.ok(customer);
    }

    /**
     *
     * @return -
     */
    @PutMapping("/change_address")
    public ResponseEntity<?> updateAddress(
            @RequestBody @Valid Customer customer) {
        Address newActualAddress = customer.getActualAddress();
        LocalDateTime timeCreatedActualAddress = addressService
                .getOne(newActualAddress.getId())
                .getCreated();
        newActualAddress.setCreated(timeCreatedActualAddress);
        newActualAddress.setModified(LocalDateTime.now());
        addressService.save(newActualAddress);
        customer.setActualAddress(newActualAddress);
        customerService.save(customer);
        return ResponseEntity.ok(customer);
    }

    /**
     *
     * @param id - id клиента
     * @return - response status
     */
    @DeleteMapping("/delete_customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        customerService.delete(customerService.getOne(id));

        return ResponseEntity.ok("Delete completed");
    }
}
