package com.broj.brojqlocker.controller;

import com.broj.brojqlocker.entity.LockerRoom;
import com.broj.brojqlocker.service.LockerRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/locker-rooms")
@RequiredArgsConstructor
public class LockerRoomController {
    
    private final LockerRoomService lockerRoomService;
    
    @GetMapping
    public List<LockerRoom> getAllLockerRooms() {
        return lockerRoomService.getAllLockerRooms();
    }
    
    @GetMapping("/center/{centerId}")
    public List<LockerRoom> getLockerRoomsByCenter(@PathVariable Long centerId) {
        return lockerRoomService.getLockerRoomsByCenter(centerId);
    }
}