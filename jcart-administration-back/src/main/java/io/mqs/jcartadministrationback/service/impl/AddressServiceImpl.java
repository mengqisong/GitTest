package io.mqs.jcartadministrationback.service.impl;

import io.mqs.jcartadministrationback.dao.AddressMapper;
import io.mqs.jcartadministrationback.po.Address;
import io.mqs.jcartadministrationback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public Address getById(Integer defaultAddressId) {
        return addressMapper.selectByPrimaryKey(defaultAddressId);
    }
}
