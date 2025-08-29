package com.broj.brojqlocker.dto;

import lombok.Data;

@Data
public class CustomerInfo {
    private Long customerId;
    private String name;
    private String phoneNumber;
    private boolean hasLockerTicket;
}