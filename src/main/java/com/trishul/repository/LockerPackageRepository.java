package com.trishul.repository;

import com.trishul.model.LockerPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LockerPackageRepository {
    public static List<LockerPackage> lockerPackages = new ArrayList<>();


    public Optional<LockerPackage> getLockerByLockerId(String id) {
        return lockerPackages.stream().filter(lp -> lp.getLockerId().equals(id)).findFirst();
    }
}
