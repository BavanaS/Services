package com.quinbay.CustomerService.controller;

import com.quinbay.CustomerService.model.vo.ProductVO;
import com.quinbay.CustomerService.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/httpCustomerGateway")
public class HttpController
{

    @Autowired
    CustomerServiceInterface customerServiceInterface;

    @GetMapping("/customerGateway")
    public List<ProductVO> getCustomerGatewayDetails()
    {
        return customerServiceInterface.getProduct();
    }

    @GetMapping("/customerGatewayFilter")
    public List<ProductVO> getCustomerGatewayDetailsFilter(@RequestParam(value="name") String name)
    {
        return customerServiceInterface.getFilterProduct(name);
    }

    @PostMapping("/customerAdd")
    public String postProduct(@RequestBody ProductVO product)
    {
        return customerServiceInterface.postProductList(product);
    }

    @PutMapping("/customerUpdate")
    public String updateProduct(@RequestBody ProductVO product,@RequestParam(value = "id") long id)
    {
        return customerServiceInterface.updateProductList(product,id);
    }


    @DeleteMapping("/customerDelete")
    public String deleteProduct(@RequestBody ProductVO product)
    {
        return customerServiceInterface.deleteProductList(product);
    }
}

