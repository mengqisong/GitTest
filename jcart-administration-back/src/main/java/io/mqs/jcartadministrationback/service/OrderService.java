package io.mqs.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.mqs.jcartadministrationback.dto.in.OrderSearchInDTO;
import io.mqs.jcartadministrationback.dto.out.OrderListOutDTO;
import io.mqs.jcartadministrationback.dto.out.OrderShowOutDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderService {
    Page<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,Integer pageNum);

    OrderShowOutDTO getById(Long orderId);
}
