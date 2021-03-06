package io.mqs.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.mqs.jcartadministrationback.dto.in.CustomerSearchInDTO;
import io.mqs.jcartadministrationback.dto.in.CustomerSetStatusInDTO;
import io.mqs.jcartadministrationback.dto.out.CustomerShowOutDTO;
import io.mqs.jcartadministrationback.po.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerService {
    Page<Customer> search(CustomerSearchInDTO customerSearchInDT,Integer pageNum);

    Customer show(Integer customerId);

    void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO);
}
