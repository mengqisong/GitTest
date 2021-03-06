package io.mqs.jcartadministrationback.service;

import io.mqs.jcartadministrationback.po.OrderHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryService {
    List<OrderHistory> getListByOrderId(Long orderId);

    Long create(OrderHistory orderHistory);
}
