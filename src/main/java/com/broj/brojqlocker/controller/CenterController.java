package com.broj.brojqlocker.controller;

import com.broj.brojqlocker.dto.CenterInfo;
import com.broj.brojqlocker.service.CenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/centers")
@RequiredArgsConstructor
public class CenterController {
    
    private final CenterService centerService;
    
    @GetMapping
    public List<CenterInfo> getAllCenters() {
        return centerService.getAllCenters();
    }
}