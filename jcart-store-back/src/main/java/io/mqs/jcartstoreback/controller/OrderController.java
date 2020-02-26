package io.mqs.jcartstoreback.controller;

import io.mqs.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.mqs.jcartstoreback.dto.out.OrderListOutDTO;
import io.mqs.jcartstoreback.dto.out.OrderShowOutDTO;
import io.mqs.jcartstoreback.dto.out.PageOutDTO;
import io.mqs.jcartstoreback.dto.out.ProductShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/checkout")
    public Integer checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }
}
