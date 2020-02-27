package io.mqs.jcartadministrationback.dao;

import com.github.pagehelper.Page;
import io.mqs.jcartadministrationback.dto.out.ProductListOutDTO;
import io.mqs.jcartadministrationback.po.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    void forDelete(@Param("productIds") List<Integer> productIds);

    Page<ProductListOutDTO> search();

}