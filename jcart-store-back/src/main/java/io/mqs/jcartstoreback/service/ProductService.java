package io.mqs.jcartstoreback.service;


import com.github.pagehelper.Page;
import io.mqs.jcartstoreback.dto.out.ProductListOutDTO;
import io.mqs.jcartstoreback.dto.out.ProductShowOutDTO;
import io.mqs.jcartstoreback.po.Product;

public interface ProductService {

    Product getById(Integer productId);

    ProductShowOutDTO getShowById(Integer productId);

    Page<ProductListOutDTO> search(Integer pageNum);

}
