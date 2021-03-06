package io.mqs.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.mqs.jcartadministrationback.dao.CustomerMapper;
import io.mqs.jcartadministrationback.dto.in.CustomerSearchInDTO;
import io.mqs.jcartadministrationback.dto.in.CustomerSetStatusInDTO;
import io.mqs.jcartadministrationback.dto.out.CustomerShowOutDTO;
import io.mqs.jcartadministrationback.po.Customer;
import io.mqs.jcartadministrationback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Page<Customer> search(CustomerSearchInDTO customerSearchInDTO,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        return customerMapper.search(
                customerSearchInDTO.getUsername(),
                customerSearchInDTO.getRealName(),
                customerSearchInDTO.getMobile(),
                customerSearchInDTO.getEmail(),
                customerSearchInDTO.getStatus());
    }

    @Override
    public Customer show(Integer customerId) {
        return customerMapper.selectByPrimaryKey(customerId);
    }

    @Override
    public void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO) {
        Customer customer = new Customer();
        customer.setCustomerId(customerSetStatusInDTO.getCustomerId());
        customer.setStatus(customerSetStatusInDTO.getStatus());
        customerMapper.updateByPrimaryKeySelective(customer);
    }
}
