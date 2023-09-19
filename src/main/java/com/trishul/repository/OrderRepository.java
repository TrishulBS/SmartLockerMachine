package com.trishul.repository;

import com.trishul.model.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    public static Map<String, Order> orderMap = new HashMap<>();

    public static Order getOrder(String id){
        return orderMap.get(id);
    }
}
