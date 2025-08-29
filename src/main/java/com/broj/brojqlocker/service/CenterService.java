package com.broj.brojqlocker.service;

import com.broj.brojqlocker.dto.CenterInfo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CenterService {
    
    private final Map<Long, CenterInfo> centerCache = new ConcurrentHashMap<>();
    
    public List<CenterInfo> getAllCenters() {
        // Mock 데이터 - 실제로는 메인 CRM 서비스 API 호출
        return List.of(
            createCenter(1L, "강남점", "서울시 강남구"),
            createCenter(2L, "홍대점", "서울시 마포구"),
            createCenter(3L, "잠실점", "서울시 송파구")
        );
    }
    
    public CenterInfo getCenterInfo(Long centerId) {
        return centerCache.computeIfAbsent(centerId, this::fetchCenterFromMainService);
    }
    
    private CenterInfo createCenter(Long id, String name, String address) {
        CenterInfo center = new CenterInfo();
        center.setCenterId(id);
        center.setCenterName(name);
        center.setAddress(address);
        return center;
    }
    
    private CenterInfo fetchCenterFromMainService(Long centerId) {
        return createCenter(centerId, "센터" + centerId, "주소" + centerId);
    }
}