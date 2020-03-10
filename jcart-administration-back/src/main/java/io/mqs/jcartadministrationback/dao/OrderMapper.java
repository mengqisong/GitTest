package io.mqs.jcartadministrationback.dao;

import com.github.pagehelper.Page;
import io.mqs.jcartadministrationback.dto.out.OrderListOutDTO;
import io.mqs.jcartadministrationback.po.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Page<OrderListOutDTO> search(
            @Param("orderId")Long orderId,
            @Param("customerName")String customerName,
            @Param("status")Byte status,
            @Param("totalPrice")Double totalPrice);
}