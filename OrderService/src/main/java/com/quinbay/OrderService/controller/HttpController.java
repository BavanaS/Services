package com.quinbay.OrderService.controller;

import com.quinbay.OrderService.model.entity.Orders;
import com.quinbay.OrderService.service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderService")
public class HttpController {

    @Autowired
    OrderServiceInterface orderServiceInterface;

    @GetMapping("/getPurchaseOrders")
    public List<Orders> getAllPurchaseOrders(){
        return orderServiceInterface.getAllPurchaseOrders();

    }

    @GetMapping("/getCustomerOrder/{customerId}")
    public List<Orders> getOrder(@PathVariable Long customerId){
        return orderServiceInterface.getPurchaseOrder(customerId);
    }

    @PostMapping("/addPurchaseOrder")
    public String addPurchaseOrder(@RequestBody Orders order){
        return orderServiceInterface.addPurchaseOrder(order);
    }

    @PostMapping("/purchaseProduct")
    public String purchaseProduct(@RequestBody Orders order){
        return orderServiceInterface.purchaseProduct(order);
    }

}
