package com.broj.brojqlocker.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class LockerRoom {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String roomCode;
    
    private String roomName;
    
    private Long centerId; // 피트니스 센터 ID (외부 참조)
}