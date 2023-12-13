package com.quinbay.OrderService.service;

import com.quinbay.OrderService.model.entity.Orders;
import java.util.*;

public interface OrderServiceInterface
{
    List<Orders> getAllPurchaseOrders();
    String addPurchaseOrder(Orders order);
    List<Orders> getPurchaseOrder(Long customerId);
    String purchaseProduct(Orders order);
}
