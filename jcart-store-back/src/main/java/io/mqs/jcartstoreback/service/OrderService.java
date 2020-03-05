package io.mqs.jcartstoreback.service;

import com.github.pagehelper.Page;
import io.mqs.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.mqs.jcartstoreback.dto.out.OrderShowOutDTO;
import io.mqs.jcartstoreback.po.Order;

public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                  Integer customerId);

    Page<Order> getByCustomerId(Integer pageNum, Integer customerId);

    OrderShowOutDTO getById(Long orderId);

}
