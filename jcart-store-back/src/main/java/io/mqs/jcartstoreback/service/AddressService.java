package io.mqs.jcartstoreback.service;

import io.mqs.jcartstoreback.po.Address;

import java.util.List;

public interface AddressService {

    Address getById(Integer addressId);

    List<Address> getByCustomerId(Integer customerId);

    Integer create(Address address);

    void update(Address address);

    void delete(Integer addressId);

}
