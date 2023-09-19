package com.trishul.repository;

import com.trishul.model.GeoLocation;
import com.trishul.model.Locker;
import com.trishul.model.LockerSize;
import com.trishul.model.LockerStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LockerRepository {
    public static List<Locker> lockers = new ArrayList<>();
    public static Map<String, Locker> lockerMap = new HashMap<>();

    public static Locker getLocker(LockerSize size, GeoLocation location){

        List<Locker> lockerList = lockers.stream()
                .filter(locker -> locker.getLockerStatus() == LockerStatus.AVAILABLE &&
                        locker.getLockerSize() == size).collect(Collectors.toList());

        if (lockerList!= null && lockerList.size()>0){
            return lockerList.get(0);
        }
        return null;

    }
}
