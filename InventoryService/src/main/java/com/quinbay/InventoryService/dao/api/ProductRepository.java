package com.quinbay.InventoryService.dao.api;

import com.quinbay.InventoryService.controller.Product;
import com.quinbay.InventoryService.model.entity.Products;
import com.quinbay.InventoryService.controller.InventoryImpl;
import com.quinbay.InventoryService.model.vo.ProductVO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ProductRepository extends JpaRepository<Products, Long>
{
    //@Override
    List<Products> findByName(String name);
    Optional<Products> findById(Long id);


    @Override
    Products save(Products products);
}
