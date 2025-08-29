package com.broj.brojqlocker.repository;

import com.broj.brojqlocker.entity.LockerRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface LockerRoomRepository extends JpaRepository<LockerRoom, Long> {
    Optional<LockerRoom> findByRoomCode(String roomCode);
    List<LockerRoom> findByCenterId(Long centerId);
}