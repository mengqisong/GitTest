package io.mqs.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.mqs.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.mqs.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.mqs.jcartadministrationback.dto.out.PageOutDTO;
import io.mqs.jcartadministrationback.dto.out.ProductListOutDTO;
import io.mqs.jcartadministrationback.dto.out.ProductShowOutDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {
    Integer create(ProductCreateInDTO productCreateInDTO);

    void update(ProductUpdateInDTO productUpdateInDTO);

    void delete(Integer productId);

    void forDelete(@Param("productIds") List<Integer> productIds);

    Page<ProductListOutDTO> search(Integer pageNum);

    ProductShowOutDTO getById(Integer productId);
}
