package com.broj.brojqlocker.service;

import com.broj.brojqlocker.dto.CustomerInfo;
import com.broj.brojqlocker.entity.Locker;
import com.broj.brojqlocker.entity.LockerRoom;
import com.broj.brojqlocker.repository.LockerRepository;
import com.broj.brojqlocker.repository.LockerRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LockerService {
    
    private final LockerRepository lockerRepository;
    private final LockerRoomRepository lockerRoomRepository;
    private final CustomerService customerService;
    
    public List<Locker> getAllLockersByRoom(Long roomId) {
        LockerRoom room = lockerRoomRepository.findById(roomId)
            .orElseThrow(() -> new RuntimeException("락커룸을 찾을 수 없습니다"));
        return lockerRepository.findByLockerRoom(room);
    }
    
    public List<Locker> getAvailableLockers(Long roomId) {
        LockerRoom room = lockerRoomRepository.findById(roomId)
            .orElseThrow(() -> new RuntimeException("락커룸을 찾을 수 없습니다"));
        return lockerRepository.findByLockerRoomAndStatus(room, Locker.LockerStatus.AVAILABLE);
    }
    
    public Locker assignLocker(Long lockerId, Long customerId) {
        CustomerInfo customer = customerService.getCustomerInfo(customerId);
        if (!customer.isHasLockerTicket()) {
            throw new RuntimeException("락커 이용권이 없습니다");
        }
        
        Locker locker = lockerRepository.findById(lockerId)
            .orElseThrow(() -> new RuntimeException("락커를 찾을 수 없습니다"));
        
        if (locker.getStatus() != Locker.LockerStatus.AVAILABLE) {
            throw new RuntimeException("사용할 수 없는 락커입니다");
        }
        
        locker.setStatus(Locker.LockerStatus.OCCUPIED);
        locker.setCustomerId(customerId);
        return lockerRepository.save(locker);
    }
    
    public Locker releaseLocker(Long customerId) {
        Locker locker = lockerRepository.findByCustomerId(customerId)
            .orElseThrow(() -> new RuntimeException("배정된 락커가 없습니다"));
        
        locker.setStatus(Locker.LockerStatus.AVAILABLE);
        locker.setCustomerId(null);
        return lockerRepository.save(locker);
    }
}