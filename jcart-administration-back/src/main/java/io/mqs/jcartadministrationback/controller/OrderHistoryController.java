package io.mqs.jcartadministrationback.controller;

import com.sun.org.apache.regexp.internal.RE;
import io.mqs.jcartadministrationback.dto.in.OrderHistoryCreateInDTO;
import io.mqs.jcartadministrationback.dto.out.OrderHistoryListOutDTO;
import io.mqs.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderhistory")
public class OrderHistoryController {

    @GetMapping("/getListByOrderId")
    public List<OrderHistoryListOutDTO> getListByOrderId(@RequestParam Long orderHistoryId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody OrderHistoryCreateInDTO orderHistoryCreateInDTO){
        return null;
    }
}
