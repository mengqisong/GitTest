package io.mqs.jcartstoreback.service;

import io.mqs.jcartstoreback.dto.in.CustomerRegisterInDTO;
import io.mqs.jcartstoreback.po.Customer;

public interface CustomerService {

    Integer register(CustomerRegisterInDTO customerRegisterInDTO);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    Customer getByEmail(String email);

    void update(Customer customer);

}
