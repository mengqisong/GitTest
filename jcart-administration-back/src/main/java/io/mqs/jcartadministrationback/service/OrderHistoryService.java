package io.mqs.jcartadministrationback.service;

import io.mqs.jcartadministrationback.po.OrderHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryService {
    List<OrderHistory> getListByOrderId(Long orderHistoryId);

    Long create(OrderHistory orderHistory);
}
