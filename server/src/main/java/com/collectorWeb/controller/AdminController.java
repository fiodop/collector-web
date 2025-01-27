package com.collectorWeb.controller;

import com.collectorWeb.model.dto.DebtorDto;
import com.collectorWeb.service.DebtService;
import com.collectorWeb.service.DebtorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/collector/admin")
@AllArgsConstructor
@PreAuthorize("isAuthenticated()")
public class AdminController {
    private static DebtService debtService;
    private static DebtorService debtorService;

    @GetMapping
    public ResponseEntity<List<DebtorDto>> getAllDebtors(){
        return ResponseEntity.ok(debtorService.getAllDebtors());
    }
}
