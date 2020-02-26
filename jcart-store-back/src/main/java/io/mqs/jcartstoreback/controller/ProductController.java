package io.mqs.jcartstoreback.controller;

import io.mqs.jcartstoreback.dto.in.ProductSearchInDTO;
import io.mqs.jcartstoreback.dto.out.PageOutDTO;
import io.mqs.jcartstoreback.dto.out.ProductListOutDTO;
import io.mqs.jcartstoreback.dto.out.ProductShowOutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        return null;
    }

}
