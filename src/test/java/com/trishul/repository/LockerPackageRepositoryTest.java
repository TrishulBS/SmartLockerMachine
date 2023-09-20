package com.trishul.repository;

import com.trishul.TestData;
import com.trishul.model.LockerPackage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LockerPackageRepositoryTest {
    @BeforeAll
    public static void setup() {
        LockerPackageRepository.lockerPackages.add(TestData.getLockerPackage());
    }

    @Test
    public void shouldGetByLockerId() {
        String lockerId = LockerPackageRepository.lockerPackages.get(0).getLockerId();
        Optional<LockerPackage> lockerPackage =
                LockerPackageRepository.getLockerByLockerId(lockerId);
        assertNotNull(lockerPackage.get());

    }
}
