package com.quinbay.OrderService.dao.api;

import com.quinbay.OrderService.model.entity.Orders;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.function.Function;

public interface OrderRepository extends MongoRepository<Orders,Long> {

    List<Orders> findByCustomerId(Long customerId);
    List<Orders> findAll();
    String save(Orders order);
}

