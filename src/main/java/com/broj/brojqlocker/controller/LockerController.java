package com.broj.brojqlocker.controller;

import com.broj.brojqlocker.entity.Locker;
import com.broj.brojqlocker.service.LockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lockers")
@RequiredArgsConstructor
public class LockerController {
    
    private final LockerService lockerService;
    
    @GetMapping("/room/{roomId}")
    public List<Locker> getAllLockersByRoom(@PathVariable Long roomId) {
        return lockerService.getAllLockersByRoom(roomId);
    }
    
    @GetMapping("/room/{roomId}/available")
    public List<Locker> getAvailableLockers(@PathVariable Long roomId) {
        return lockerService.getAvailableLockers(roomId);
    }
    
    @PostMapping("/{lockerId}/assign")
    public ResponseEntity<Locker> assignLocker(
            @PathVariable Long lockerId,
            @RequestParam Long customerId) {
        Locker locker = lockerService.assignLocker(lockerId, customerId);
        return ResponseEntity.ok(locker);
    }
    
    @PostMapping("/customer/{customerId}/release")
    public ResponseEntity<Locker> releaseLocker(@PathVariable Long customerId) {
        Locker locker = lockerService.releaseLocker(customerId);
        return ResponseEntity.ok(locker);
    }
}