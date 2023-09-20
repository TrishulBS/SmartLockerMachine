package com.trishul.service;

import com.trishul.exception.LockerCodeMisMatchException;
import com.trishul.exception.LockerNotFoundException;
import com.trishul.exception.PackPickTimeExceededException;
import com.trishul.exception.PickupCodeExpiredException;
import com.trishul.model.*;
import com.trishul.repository.LockerLocationRepository;
import com.trishul.repository.LockerPackageRepository;
import com.trishul.repository.LockerRepository;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public class LockerService {
    public Locker findLockerById(String id){
        return LockerRepository.lockerMap.get(id);
    }
    public Locker getLocker(LockerSize size, GeoLocation lockerLocation){
        return getAvailableLocker(size, lockerLocation);
    }

    public void pickFromLocker (String lockerId, String password, LocalDateTime localDateTime) throws
            LockerNotFoundException, LockerCodeMisMatchException, PickupCodeExpiredException, PackPickTimeExceededException {
        Optional<LockerPackage> lockerPackage = LockerPackageRepository.getLockerByLockerId(lockerId);

        if(lockerPackage.isPresent() == false) {
            throw new LockerNotFoundException("locker with locker id not found");
        }
        if (lockerPackage.get().verifyCode(password) == false){
            throw new LockerCodeMisMatchException("invalid password");
        }
        if (lockerPackage.get().isValidCode(localDateTime)){
            throw new PickupCodeExpiredException("pickup code expired");
        }

        Locker locker = LockerRepository.lockerMap.get(lockerId);
        if (canPickFromLocker(lockerId, localDateTime)) {
            locker.setLockerStatus(LockerStatus.AVAILABLE);
            lockerPackage.get().setCode(null);
        } else {
            lockerPackage.get().setCode(null);
            throw new PackPickTimeExceededException("Package not picked for x days");
        }






    }

    private boolean canPickFromLocker(String lockerId, LocalDateTime localDateTime){
        Locker locker = LockerRepository.lockerMap.get(lockerId);
        LockerLocation lockerLocation = LockerLocationRepository.getLockerLocation(locker.getLocationId());
        LocationTiming locationTiming = lockerLocation.getLocationTiming();
        Timing timing = locationTiming.getTimingMap().get(localDateTime.getDayOfWeek());
        Time currentTime = Time.valueOf(getTimeFromDate(localDateTime));
        if (currentTime.after(timing.getOpenTime()) && currentTime.before(timing.getCloseTime())) {
            return true;
        }
        return false;
    }

    private Locker getAvailableLocker(LockerSize lockerSize,
                                      GeoLocation geoLocation) {
        return checkAndGetAvailableLockers(lockerSize, geoLocation);
    }

    private Locker checkAndGetAvailableLockers(LockerSize lockerSize,
                                               GeoLocation geoLocation) {
        Locker locker = LockerRepository.getLocker(lockerSize, geoLocation);
        locker.setLockerStatus(LockerStatus.BOOKED);
        return locker;
    }

    private String getTimeFromDate(LocalDateTime localDateTime) {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = localDateFormat.format(new Date());
        return time;
    }
}
