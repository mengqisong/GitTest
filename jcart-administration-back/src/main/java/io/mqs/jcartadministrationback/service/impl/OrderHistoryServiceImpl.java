package io.mqs.jcartadministrationback.service.impl;

import io.mqs.jcartadministrationback.dao.OrderHistoryMapper;
import io.mqs.jcartadministrationback.dao.OrderMapper;
import io.mqs.jcartadministrationback.po.Order;
import io.mqs.jcartadministrationback.po.OrderHistory;
import io.mqs.jcartadministrationback.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Autowired
    OrderHistoryMapper orderHistoryMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<OrderHistory> getListByOrderId(Long orderHistoryId) {
        return orderHistoryMapper.selectByOrderId(orderHistoryId);
    }

    @Override
    @Transactional
    public Long create(OrderHistory orderHistory) {
        orderHistoryMapper.insertSelective(orderHistory);
        Order order = new Order();
        order.setOrderId(orderHistory.getOrderId());
        order.setStatus(orderHistory.getOrderStatus());
        order.setUpdateTime(new Date());
        orderMapper.updateByPrimaryKey(order);
        Long orderHistoryId = orderHistory.getOrderHistoryId();
        return orderHistoryId;
    }
}
