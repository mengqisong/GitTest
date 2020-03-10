package io.mqs.jcartadministrationback.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.mqs.jcartadministrationback.dao.CustomerMapper;
import io.mqs.jcartadministrationback.dao.OrderDetailMapper;
import io.mqs.jcartadministrationback.dao.OrderMapper;
import io.mqs.jcartadministrationback.dto.in.OrderSearchInDTO;
import io.mqs.jcartadministrationback.dto.out.OrderListOutDTO;
import io.mqs.jcartadministrationback.dto.out.OrderShowOutDTO;
import io.mqs.jcartadministrationback.po.Customer;
import io.mqs.jcartadministrationback.po.Order;
import io.mqs.jcartadministrationback.po.OrderDetail;
import io.mqs.jcartadministrationback.service.OrderService;
import io.mqs.jcartadministrationback.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public Page<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        return orderMapper.search(
                orderSearchInDTO.getOrderId(),
                orderSearchInDTO.getCustomerName(),
                orderSearchInDTO.getStatus(),
                orderSearchInDTO.getTotalPrice()
        );
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);

        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setOrderId(orderId);
        orderShowOutDTO.setCustomerId(order.getCustomerId());

        Customer customer = customerMapper.selectByPrimaryKey(order.getCustomerId());
        orderShowOutDTO.setCustomerName(customer.getRealName());
        orderShowOutDTO.setStatus(order.getStatus());
        orderShowOutDTO.setTotalPrice(order.getTotalPrice());
        orderShowOutDTO.setRewordPoints(order.getRewordPoints());
        orderShowOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
        orderShowOutDTO.setUpdateTimestamp(order.getUpdateTime().getTime());

        orderShowOutDTO.setShipMethod(orderDetail.getShipMethod());
        orderShowOutDTO.setShipAddress(orderDetail.getShipAddress());
        orderShowOutDTO.setShipPrice(orderDetail.getShipPrice());
        orderShowOutDTO.setPayMethod(orderDetail.getPayMethod());
        orderShowOutDTO.setInvoiceAddress(orderDetail.getInvoiceAddress());
        orderShowOutDTO.setInvoicePrice(orderDetail.getInvoicePrice());
        orderShowOutDTO.setComment(orderDetail.getComment());

        List<OrderProductVO> orderProductVOS = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVO.class);
        orderShowOutDTO.setOrderProducts(orderProductVOS);

        return orderShowOutDTO;
    }
}
