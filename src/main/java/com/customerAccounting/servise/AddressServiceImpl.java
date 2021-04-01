package com.customerAccounting.servise;

import com.customerAccounting.entities.Address;
import com.customerAccounting.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    AddressRepository addressRepository;
    @Autowired
    public void setAddressRepository( AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getOne(Long id) {
        return addressRepository.getOne(id);
    }

    @Override
    public void save(Address object) {
        addressRepository.save(object);
    }

    @Override
    public void delete(Address object) {
        addressRepository.delete(object);
    }
}
