package com.quinbay.InventoryService.controller;

import com.quinbay.InventoryService.dao.api.CategoryRepository;
import com.quinbay.InventoryService.model.vo.ProductVO;
import com.quinbay.InventoryService.service.InventoryServiceInterface;
import com.quinbay.InventoryService.model.entity.Products;
import com.quinbay.InventoryService.model.constant.FieldNames;
import com.quinbay.InventoryService.data.Orders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.InventoryService.dao.api.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.Optional;

@Service("inventoryServiceInterface")
public class InventoryImpl implements InventoryServiceInterface
{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<ProductVO> getProductList()
    {
        List<com.quinbay.InventoryService.model.entity.Products> productList=productRepository.findAll();
        ObjectMapper objectMapper= new ObjectMapper();
        return objectMapper.convertValue(productList,List.class);
    }

    @Override
    public List<ProductVO> getProduct(String name)
    {
        List<Products> productList = productRepository.findByName(name);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(productList, List.class);
    }

    @Override
    public String postProductList(ProductVO product)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        productRepository.save(objectMapper.convertValue(product, Products.class));
        return "Product added";
    }

    @Override
    public String updateProductList(ProductVO product,Long id)
    {
        Optional<Products> productList = productRepository.findById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        Products productUpdate = objectMapper.convertValue(product,Products.class);


        if(productList.isEmpty())
            return "not found";

        else {
            Products p = productList.get();
            p.setId(productUpdate.getId());
            p.setName(productUpdate.getName());
            p.setPrice(productUpdate.getPrice());
            p.setQuantity(productUpdate.getQuantity());
            p.setCategory(productUpdate.getCategory());
            productRepository.save(p);
        }

        return "Done";
    }

    @Override
    public String deleteProductList(ProductVO productVO)
    {

        ObjectMapper objectMapper=new ObjectMapper();
        productRepository.delete(objectMapper.convertValue(productVO,Products.class));
        return "deleted";
    }

    @Override
    public String purchaseProduct(Orders order) {
        ObjectMapper objectMapper=new ObjectMapper();
        Products product=productRepository.findById(order.getProductId()).get();

        if(Integer.parseInt(product.getQuantity())>Integer.parseInt(order.getProductQuantity()))
        {
            int value=Integer.parseInt(product.getQuantity())-Integer.parseInt(order.getProductQuantity());
            product.setQuantity(String.valueOf(value));
            productRepository.save(product);
            return "Item Available";
        }
        return "Item not available";


    }
}
