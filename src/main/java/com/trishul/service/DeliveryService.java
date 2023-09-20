package com.trishul.service;

import com.trishul.exception.PackageSizeMappingException;
import com.trishul.model.*;
import com.trishul.repository.LockerPackageRepository;
import com.trishul.utils.IdGenerator;
import com.trishul.utils.SizeUtil;

import java.util.List;

public class DeliveryService {
    NotificationService notificationService = new NotificationService();
    OrderService orderService = new OrderService();
    LockerService lockerService = new LockerService();
    public void deliver(String orderId) throws PackageSizeMappingException {
        Order order = orderService.getOrder(orderId);
        List<Item> items = orderService.getItemsForOrder(orderId);
        Pack pack = new Pack(orderId, items);
        LockerSize lockerSize = SizeUtil.getLockerSizeForPack(pack.getPackageSize());
        Locker locker = new LockerService().getLocker(lockerSize, order.getDeliveryGeoLocation());
        LockerPackage lockerPackage = new LockerPackage();
        lockerPackage.setOrderId(orderId);
        lockerPackage.setLockerId(locker.getId());
        lockerPackage.setCode(IdGenerator.generateId(6));
        LockerPackageRepository.lockerPackages.add(lockerPackage);
        locker.setLockerStatus(LockerStatus.CLOSED);
        notificationService.notifyCustomerOrder(lockerPackage);
    }
}
