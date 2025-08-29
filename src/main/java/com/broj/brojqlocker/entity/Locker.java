package com.broj.brojqlocker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Locker {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String lockerNumber;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locker_room_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private LockerRoom lockerRoom;
    
    @Enumerated(EnumType.STRING)
    private LockerStatus status;
    
    private Long customerId; // 고객 ID (외부 참조)
    
    public enum LockerStatus {
        AVAILABLE, OCCUPIED, MAINTENANCE
    }
}