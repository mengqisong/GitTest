package io.mqs.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.mqs.jcartadministrationback.dao.CustomerMapper;
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
    public Page<Customer> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        return customerMapper.search();
    }

    @Override
    public Customer show(Integer customerId) {
        return customerMapper.selectByPrimaryKey(customerId);
    }
}
