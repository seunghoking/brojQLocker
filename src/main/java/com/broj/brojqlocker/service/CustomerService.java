package com.broj.brojqlocker.service;

import com.broj.brojqlocker.dto.CustomerInfo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    
    private final Map<Long, CustomerInfo> customerCache = new ConcurrentHashMap<>();
    private final Map<String, CustomerInfo> phoneCache = new ConcurrentHashMap<>();
    
    public List<CustomerInfo> getAllCustomers() {
        // Mock 데이터 - 실제로는 메인 CRM 서비스 API 호출
        return List.of(
            createCustomer(1L, "김철수", "010-1234-5678", true),
            createCustomer(2L, "이영희", "010-2345-6789", false),
            createCustomer(3L, "박민수", "010-3456-7890", true),
            createCustomer(4L, "최지영", "010-4567-8901", false),
            createCustomer(123L, "홍길동", "010-9999-9999", true)
        );
    }
    
    public CustomerInfo getCustomerInfo(Long customerId) {
        return customerCache.computeIfAbsent(customerId, this::fetchCustomerFromMainService);
    }
    
    public List<CustomerInfo> searchByPhoneNumber(String phoneNumber) {
        return getAllCustomers().stream()
            .filter(customer -> customer.getPhoneNumber().contains(phoneNumber))
            .collect(Collectors.toList());
    }
    
    private CustomerInfo createCustomer(Long id, String name, String phone, boolean hasTicket) {
        CustomerInfo customer = new CustomerInfo();
        customer.setCustomerId(id);
        customer.setName(name);
        customer.setPhoneNumber(phone);
        customer.setHasLockerTicket(hasTicket);
        return customer;
    }
    
    private CustomerInfo fetchCustomerFromMainService(Long customerId) {
        return createCustomer(customerId, "고객" + customerId, "010-0000-" + String.format("%04d", customerId), customerId % 2 == 1);
    }
}