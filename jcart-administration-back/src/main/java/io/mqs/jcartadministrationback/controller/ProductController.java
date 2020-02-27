package io.mqs.jcartadministrationback.controller;

import com.github.pagehelper.Page;
import io.mqs.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.mqs.jcartadministrationback.dto.in.ProductSearchInDTO;
import io.mqs.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.mqs.jcartadministrationback.dto.out.PageOutDTO;
import io.mqs.jcartadministrationback.dto.out.ProductListOutDTO;
import io.mqs.jcartadministrationback.dto.out.ProductShowOutDTO;
import io.mqs.jcartadministrationback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<ProductListOutDTO> page = productService.search(pageNum);

        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        return productService.getById(productId);
    }

    @PostMapping("/create")
    public Integer creatr(@RequestBody ProductCreateInDTO productCreateInDTO){
        return productService.create(productCreateInDTO);
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){
        productService.update(productUpdateInDTO);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer productId){
        productService.delete(productId);
    }

    @PostMapping("/forDelete")
    public void forDelete(@RequestBody List<Integer> productIds){
        productService.forDelete(productIds);
    }


}
