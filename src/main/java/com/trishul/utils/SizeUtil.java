package com.trishul.utils;

import com.trishul.exception.PackageSizeMappingException;
import com.trishul.model.LockerSize;

public class SizeUtil {
    public static LockerSize getLockerSizeForPack(double packSize)
            throws PackageSizeMappingException {
        if (packSize<10){
            return LockerSize.XS;
        } else if (packSize>=10 & packSize<20) {
            return LockerSize.S;
        } else if (packSize>=20 & packSize<30) {
            return LockerSize.M;
        } else if (packSize>=30 & packSize<40) {
            return LockerSize.L;
        } else if (packSize>=40 & packSize<60) {
            return LockerSize.XL;
        } else if (packSize>=60 & packSize<100) {
            return LockerSize.XXL;
        }else throw new  PackageSizeMappingException("Too large to fit in the locker");
    }



}
