package io.mqs.jcartadministrationback.service;

import io.mqs.jcartadministrationback.po.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressService {
    Address getById(Integer defaultAddressId);

    List<Address> getByCustomerId(Integer customerId);
}
