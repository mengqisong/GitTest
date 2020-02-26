package io.mqs.jcartadministrationback.controller;

import io.mqs.jcartadministrationback.dto.in.CustomerSearchInDTO;
import io.mqs.jcartadministrationback.dto.out.CustomerListOutDTO;
import io.mqs.jcartadministrationback.dto.out.CustomerShowOutDTO;
import io.mqs.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    //查询
    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO
                                                ,@RequestParam Integer pageNum){
        return null;
    }

    //回显
    @GetMapping("/show")
    public CustomerShowOutDTO show(@RequestParam Integer customerId){
        return null;
    }

    //更新
    @PostMapping("/disable")
    public void disable(@RequestParam Integer customerId){
    }
}
