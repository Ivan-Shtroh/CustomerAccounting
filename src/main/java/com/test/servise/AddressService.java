package com.test.servise;


import com.test.entities.Address;

import java.time.LocalDateTime;
import java.util.List;

public interface AddressService {
    List<Address> getAll();

    Address getOne(Long id);

    void save(Address object);

    void delete(Address object);

    LocalDateTime getDateCreated(Address object);


}



