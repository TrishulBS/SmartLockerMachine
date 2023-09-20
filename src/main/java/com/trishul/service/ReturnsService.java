package com.trishul.service;

import com.trishul.model.Item;
import com.trishul.model.Locker;
import com.trishul.model.LockerStatus;

public class ReturnsService {

    public void returnItemsToLocker(Item item, Locker locker) {
        locker.setLockerStatus(LockerStatus.CLOSED);
    }
}