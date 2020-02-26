package io.mqs.jcartadministrationback.controller;

import io.mqs.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.mqs.jcartadministrationback.dto.in.ProductSearchInDTO;
import io.mqs.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.mqs.jcartadministrationback.dto.out.PageOutDTO;
import io.mqs.jcartadministrationback.dto.out.ProductListOutDTO;
import io.mqs.jcartadministrationback.dto.out.ProductShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/show")
    public ProductShowOutDTO show(@RequestParam Integer productId){return null;}

    @PostMapping("/create")
    public Integer creatr(@RequestBody ProductCreateInDTO productCreateInDTO){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){

    }


}
