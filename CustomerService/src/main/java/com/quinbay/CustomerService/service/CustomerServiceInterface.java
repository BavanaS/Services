package com.quinbay.CustomerService.service;

import com.quinbay.CustomerService.model.vo.ProductVO;
import java.util.*;

public interface CustomerServiceInterface
{
    List<ProductVO> getProduct();
    List<ProductVO> getFilterProduct(String name);
    String postProductList(ProductVO product);
    String updateProductList(ProductVO product,Long id);
    String deleteProductList(ProductVO product);
}
