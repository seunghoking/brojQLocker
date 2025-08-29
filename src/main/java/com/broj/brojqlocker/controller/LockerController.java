package com.broj.brojqlocker.controller;

import com.broj.brojqlocker.entity.Locker;
import com.broj.brojqlocker.service.LockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/locker-rooms")
@RequiredArgsConstructor
public class LockerController {
    
    private final LockerService lockerService;
    
    @GetMapping("/{roomCode}/lockers/available")
    public List<Locker> getAvailableLockers(@PathVariable String roomCode) {
        return lockerService.getAvailableLockers(roomCode);
    }
    
    @PostMapping("/{roomCode}/lockers/{lockerNumber}/assign")
    public ResponseEntity<Locker> assignLocker(
            @PathVariable String roomCode,
            @PathVariable String lockerNumber,
            @RequestParam Long customerId) {
        Locker locker = lockerService.assignLocker(roomCode, lockerNumber, customerId);
        return ResponseEntity.ok(locker);
    }
    
    @PostMapping("/customers/{customerId}/release")
    public ResponseEntity<Locker> releaseLocker(@PathVariable Long customerId) {
        Locker locker = lockerService.releaseLocker(customerId);
        return ResponseEntity.ok(locker);
    }
}