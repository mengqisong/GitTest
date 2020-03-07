package io.mqs.jcartadministrationback.service.impl;

import io.mqs.jcartadministrationback.dao.OrderHistoryMapper;
import io.mqs.jcartadministrationback.po.OrderHistory;
import io.mqs.jcartadministrationback.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Autowired
    OrderHistoryMapper orderHistoryMapper;

    @Override
    public List<OrderHistory> getListByOrderId(Long orderHistoryId) {
        return orderHistoryMapper.selectByOrderId(orderHistoryId);
    }
}
