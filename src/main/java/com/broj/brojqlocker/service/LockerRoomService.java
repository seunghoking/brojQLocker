package com.broj.brojqlocker.service;

import com.broj.brojqlocker.entity.LockerRoom;
import com.broj.brojqlocker.repository.LockerRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LockerRoomService {
    
    private final LockerRoomRepository lockerRoomRepository;
    
    public List<LockerRoom> getAllLockerRooms() {
        return lockerRoomRepository.findAll();
    }
    
    public List<LockerRoom> getLockerRoomsByCenter(Long centerId) {
        return lockerRoomRepository.findByCenterId(centerId);
    }
}