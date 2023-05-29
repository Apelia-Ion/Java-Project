package service;

import domain.Address;

import domain.Book;
import persistence.AddressRepository;


import java.util.ArrayList;
import java.util.List;

public class AddresService {
    private List<Address> addresses;


    private final AddressRepository addressRepository = AddressRepository.getInstance();

    public AddresService() {
        this.addresses = new ArrayList<>();
    }



    public Address addNewAddressToDB(Address address) {
        return addressRepository.save(address);
    }
    public List<Address> getAllAddressesDB() {
        return addressRepository.findAll();
    }
}
