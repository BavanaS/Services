package com.quinbay.InventoryService.service;

import com.quinbay.InventoryService.data.Orders;
import com.quinbay.InventoryService.model.entity.Products;
import com.quinbay.InventoryService.model.vo.ProductVO;
import java.util.*;

public interface InventoryServiceInterface
{
    List<ProductVO> getProductList();
    List<ProductVO> getProduct(String name);
    String postProductList(ProductVO product);
    String updateProductList(ProductVO product,Long id);
    String deleteProductList(ProductVO productVO);
    String purchaseProduct(Orders order);
}
