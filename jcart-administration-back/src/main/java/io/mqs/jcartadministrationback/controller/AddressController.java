package io.mqs.jcartadministrationback.controller;

import io.mqs.jcartadministrationback.dto.out.AddressListOutDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class AddressController {

    @GetMapping("/list")
    public List<AddressListOutDTO> list(Integer customerId){
        return null;
    }
}
