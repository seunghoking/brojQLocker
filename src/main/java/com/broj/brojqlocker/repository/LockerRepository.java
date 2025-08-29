package com.broj.brojqlocker.repository;

import com.broj.brojqlocker.entity.Locker;
import com.broj.brojqlocker.entity.LockerRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface LockerRepository extends JpaRepository<Locker, Long> {
    List<Locker> findByLockerRoom(LockerRoom lockerRoom);
    List<Locker> findByLockerRoomAndStatus(LockerRoom lockerRoom, Locker.LockerStatus status);
    Optional<Locker> findByCustomerId(Long customerId);
    Optional<Locker> findByLockerRoomAndLockerNumber(LockerRoom lockerRoom, String lockerNumber);
}