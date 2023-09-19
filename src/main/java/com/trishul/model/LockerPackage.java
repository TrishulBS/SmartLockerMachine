package com.trishul.model;

import com.trishul.exception.PickupCodeExpiredException;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDateTime;
@Setter
@Getter
public class LockerPackage {
    final int codeValidDays = 3;
    private String lockerId;
    private String orderId;
    private String code;
    private LocalDateTime packageDeliveredTime;


    public boolean isValidCode(LocalDateTime currentTime) throws  PickupCodeExpiredException {
        if (currentTime.compareTo(packageDeliveredTime) > 3) {
            throw new PickupCodeExpiredException("Pickup code expired.");
        }
        return true;
    }

    public boolean verifyCode(String code){
        return this.code.equals(code);
    }



}
