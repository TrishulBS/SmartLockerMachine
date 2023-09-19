package com.trishul.repository;

import com.trishul.model.LockerLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LockerLocationRepository {
    public static List<LockerLocation> lockerLocations = new ArrayList<>();

    public static LockerLocation getLockerLocation(String locationId){
        Optional<LockerLocation> lockerLocation =
                lockerLocations.stream().filter(ll -> ll.getId().equals(locationId)).findFirst();

        if (lockerLocation.isPresent()){
            return lockerLocation.get();
        }
        return null;

    }
}
