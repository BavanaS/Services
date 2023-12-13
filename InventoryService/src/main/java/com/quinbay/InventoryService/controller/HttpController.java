package com.quinbay.InventoryService.controller;

import com.quinbay.InventoryService.model.entity.Products;
import com.quinbay.InventoryService.data.Orders;
import com.quinbay.InventoryService.service.InventoryServiceInterface;
import com.quinbay.InventoryService.model.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/httpInventoryService")
public class HttpController
{
    @Autowired
    InventoryServiceInterface inventoryServiceInterface;

    //ManyToOne
    @GetMapping("/inventoryServiceGet")
    public List<ProductVO> getProductInventoryDetails()
    {
        return inventoryServiceInterface.getProductList();
    }

    @GetMapping("/inventoryServiceGetFilter")
    public List<ProductVO> getInventoryDetails(@RequestParam(value="name") String name)
    {
        return inventoryServiceInterface.getProduct(name);
    }

    @PostMapping("/inventoryAdd")
    public String postProduct(@RequestBody ProductVO product)
    {
        return inventoryServiceInterface.postProductList(product);
    }

    @PutMapping("/inventoryUpdate")
    public String updateProduct(@RequestBody ProductVO product,@RequestParam(value = "id") long id)
    {
        return inventoryServiceInterface.updateProductList(product,id);
    }

    @DeleteMapping("/inventoryDelete")
    public String deleteProduct(@RequestBody ProductVO product)
    {
        return inventoryServiceInterface.deleteProductList(product);
    }

    @PostMapping("/purchaseProduct")
    public String purchaseProduct(@RequestBody Orders order){
        return inventoryServiceInterface.purchaseProduct(order);
    }
}
