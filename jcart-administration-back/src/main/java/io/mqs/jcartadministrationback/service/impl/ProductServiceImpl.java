package io.mqs.jcartadministrationback.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.mqs.jcartadministrationback.dao.ProductDetailMapper;
import io.mqs.jcartadministrationback.dao.ProductMapper;
import io.mqs.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.mqs.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.mqs.jcartadministrationback.dto.out.ProductListOutDTO;
import io.mqs.jcartadministrationback.dto.out.ProductShowOutDTO;
import io.mqs.jcartadministrationback.po.Product;
import io.mqs.jcartadministrationback.po.ProductDetail;
import io.mqs.jcartadministrationback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductDetailMapper productDetailMapper;

    @Override
    @Transactional
    public Integer create(ProductCreateInDTO productCreateInDTO) {
        Product product = new Product();
        product.setProductCode(productCreateInDTO.getProductCode());
        product.setProductName(productCreateInDTO.getProductName());
        product.setPrice(productCreateInDTO.getPrice());
        product.setDiscount(productCreateInDTO.getDiscount());
        product.setStockQuantity(productCreateInDTO.getStockQuantity());
        product.setStatus(productCreateInDTO.getStatus());
        product.setMainPicUrl(productCreateInDTO.getMainPicUrl());
        product.setRewordPoints(productCreateInDTO.getRewordPoints());
        product.setSortOrder(productCreateInDTO.getSortOrder());
        
        String substring = productCreateInDTO.getDescription().substring(0, Math.min(100, productCreateInDTO.getDescription().length()));
        product.setProductAbstract(substring);

        productMapper.insertSelective(product);
        Integer productId = product.getProductId();

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productId);
        productDetail.setDescription(productCreateInDTO.getDescription());
        productDetail.setOtherPicUrls(JSON.toJSONString(productCreateInDTO.getOtherPicUrls()));
        productDetailMapper.insertSelective(productDetail);

        return productId;
    }

    @Override
    @Transactional
    public void update(ProductUpdateInDTO productUpdateInDTO) {
        Product product = new Product();
        product.setProductId(productUpdateInDTO.getProductId());
        product.setProductName(productUpdateInDTO.getProductName());
        product.setPrice(productUpdateInDTO.getPrice());
        product.setDiscount(productUpdateInDTO.getDiscount());
        product.setStatus(productUpdateInDTO.getStatus());
        product.setStockQuantity(productUpdateInDTO.getStockQuantity());
        product.setMainPicUrl(productUpdateInDTO.getMainPicUrl());
        product.setRewordPoints(productUpdateInDTO.getRewordPoints());
        product.setSortOrder(productUpdateInDTO.getSortOrder());
        product.setProductAbstract(productUpdateInDTO.getDescription().substring(0,Math.min(100,productUpdateInDTO.getDescription().length())));
        productMapper.updateByPrimaryKeySelective(product);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productUpdateInDTO.getProductId());
        productDetail.setDescription(productUpdateInDTO.getDescription());
        productDetail.setOtherPicUrls(JSON.toJSONString(productUpdateInDTO.getOtherPicUrls()));
        productDetailMapper.updateByPrimaryKeySelective(productDetail);

    }

    @Override
    @Transactional
    public void delete(Integer productId) {
        productMapper.deleteByPrimaryKey(productId);
        productDetailMapper.deleteByPrimaryKey(productId);
    }

    @Override
    @Transactional
    public void forDelete(List<Integer> productIds) {
        productMapper.forDelete(productIds);
        productDetailMapper.forDelete(productIds);
    }

    @Override
    public Page<ProductListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<ProductListOutDTO> page = productMapper.search();

        return page;
    }

    @Override
    @Transactional
    public ProductShowOutDTO getById(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        ProductDetail productDetail = productDetailMapper.selectByPrimaryKey(productId);

        ProductShowOutDTO productShowOutDTO = new ProductShowOutDTO();
        productShowOutDTO.setProductId(productId);
        productShowOutDTO.setProductName(product.getProductName());
        productShowOutDTO.setProductCode(product.getProductCode());
        productShowOutDTO.setPrice(product.getPrice());
        productShowOutDTO.setDiscount(product.getDiscount());
        productShowOutDTO.setStatus(product.getStatus());
        productShowOutDTO.setMainPicUrl(product.getMainPicUrl());
        productShowOutDTO.setRewordPoints(product.getRewordPoints());
        productShowOutDTO.setSortOrder(product.getSortOrder());
        productShowOutDTO.setStockQuantity(product.getStockQuantity());

        productShowOutDTO.setDescription(productDetail.getDescription());
        String otherPicUrls = productDetail.getOtherPicUrls();
        List<String> strings = JSON.parseArray(otherPicUrls, String.class);
        productShowOutDTO.setOtherPicUrls(strings);

        return productShowOutDTO;
    }
}
