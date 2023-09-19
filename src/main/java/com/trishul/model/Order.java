package com.trishul.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
    private String id;
    private List<Item> items;
    private GeoLocation deliveryGeoLocation;
}
