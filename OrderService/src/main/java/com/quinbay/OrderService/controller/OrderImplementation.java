package com.quinbay.OrderService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.OrderService.dao.api.OrderRepository;
import com.quinbay.OrderService.service.OrderServiceInterface;
import com.quinbay.OrderService.dao.api.OrderRepository;
import com.quinbay.OrderService.model.entity.Orders;
import com.quinbay.OrderService.service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service("PurchaseOrder")
public class OrderImplementation implements OrderServiceInterface {
    @Autowired
    RestTemplate restTemplate;

    private String baseUrl="http://localhost:8086//httpInventoryService";

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Orders> getAllPurchaseOrders() {
        return orderRepository.findAll();

    }

    @Override
    public String addPurchaseOrder(Orders order) {
        orderRepository.save(order);
        return "Successful";
    }

    @Override
    public List<Orders> getPurchaseOrder(Long customerId) {
        ObjectMapper objectMapper=new ObjectMapper();

        List<Orders> result = objectMapper.convertValue(orderRepository.findByCustomerId(customerId), List.class);
        return result;
    }

    @Override
    public String purchaseProduct(Orders order) {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Orders> entity=new HttpEntity(order,headers);
        System.out.println(order.getProductQuantity());
        orderRepository.save(order);

        String orderResponse= restTemplate.exchange(baseUrl+"/purchaseProduct", HttpMethod.POST, entity , String.class ).getBody();
        if(orderResponse.equals("Item Available")) {
            return "Order placed...";
        }
        return "Not available";

    }
}
