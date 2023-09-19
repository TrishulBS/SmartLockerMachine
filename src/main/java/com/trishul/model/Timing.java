package com.trishul.model;

import java.sql.Time;
import lombok.Getter;

@Getter
public class Timing {
    private Time openTime;
    private Time closeTime;

    public Timing(String openTime, String closeTime){
        this.closeTime = Time.valueOf(openTime);
        this.openTime = Time.valueOf(closeTime);
    }
}
