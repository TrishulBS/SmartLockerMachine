package com.trishul.service;

import com.trishul.model.Item;
import com.trishul.model.Order;
import com.trishul.repository.OrderRepository;

import java.util.List;

public class OrderService {

    OrderRepository orderRepository = new OrderRepository();

    public Order getOrder(String orderId) {
        return orderRepository.getOrder(orderId);
    }
    public List<Item> getItemsForOrder(String orderId) {
        return orderRepository.getOrder(orderId).getItems();
    }
    public void initiateRefund(String orderId) {
        System.out.printf("Refund for order %s initiated", orderId);
    }

}