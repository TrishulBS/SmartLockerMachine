package com.trishul.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LockerLocation {
    private String id;
    private List<Locker> lockers = new ArrayList<>();
    private LocationTiming locationTiming;
    private GeoLocation geoLocation;
}
