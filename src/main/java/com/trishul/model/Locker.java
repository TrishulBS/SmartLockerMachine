package com.trishul.model;

import com.trishul.utils.IdGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Locker {
    private String id;
    private LockerStatus lockerStatus;
    private String locationId;
    private LockerSize lockerSize;

    public Locker(LockerSize size, String locationId){
        this.id = IdGenerator.generateId(8);
        this.lockerSize = size;
        this.lockerStatus = LockerStatus.AVAILABLE;
        this.locationId = locationId;
    }


}
