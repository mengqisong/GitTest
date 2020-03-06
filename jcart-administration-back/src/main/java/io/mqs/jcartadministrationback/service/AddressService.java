package io.mqs.jcartadministrationback.service;

import io.mqs.jcartadministrationback.po.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressService {
    Address getById(Integer defaultAddressId);
}
