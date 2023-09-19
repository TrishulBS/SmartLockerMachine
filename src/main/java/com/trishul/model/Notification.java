package com.trishul.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Notification {
    private String orderId;
    private String customerId;
    private String lockerId;
    private String code;
}
