package com.collectorWeb.controller;

import com.collectorWeb.model.dto.DebtDto;
import com.collectorWeb.model.dto.DebtorDto;
import com.collectorWeb.service.DebtService;
import com.collectorWeb.service.DebtorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User collector API", description = "Controller with rest methods for users")
@RestController
@AllArgsConstructor
@RequestMapping("/collector")
@PreAuthorize("isAuthenticated()")
public class MainController {
    private static DebtService debtService;
    private static DebtorService debtorService;
    private final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Operation(
            summary = "Add new debtor",
            description = "Add new debtor to database if it not exist",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully added"),
                    @ApiResponse(responseCode = "400", description = "Request contains incorrect data")
            }
    )
    @PostMapping("/create-debtor")
    public ResponseEntity<DebtorDto> createDebtor(@RequestBody DebtorDto debtorDTO) {
        logger.info("Trying to add debtor");

        return ResponseEntity.ok(debtorService.addDebtor(debtorDTO));
    }

    @Operation(
            summary = "Add new debt",
            description = "Add new debt to database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully added"),
                    @ApiResponse(responseCode = "400", description = "Request contains incorrect data")
            }

    )
    @PostMapping("/create-debt")
    public ResponseEntity<DebtDto> createDebt(@RequestBody DebtDto debtDTO) {
        logger.info("Trying to add debt");

        return ResponseEntity.ok(debtService.add(debtDTO));
    }

    @Operation(
            summary = "Delete debt",
            description = "Delete debt in db",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Debt successfully deleted"),
                    @ApiResponse(responseCode = "400", description = "Debt doesn't exist")
            }
    )
    @DeleteMapping
    public ResponseEntity<DebtDto> deleteDebt(@RequestBody DebtDto debtDTO) {
        logger.info("Trying to delete debt");

        return ResponseEntity.ok(debtService.delete(debtDTO.getId()));
    }

    @Operation(
            summary = "Update debt",
            description = "Update debt in db",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Debt updated successfully"),
                    @ApiResponse(responseCode = "400", description = "Debt doesn't exist")
            }
    )
    @PatchMapping()
    public ResponseEntity<DebtDto> updateDebt(@RequestBody DebtDto debtDTO) {
        logger.info("Trying to update debt");

            return ResponseEntity.ok(debtService.fromEntityToDto(debtService.update(debtDTO)));
    }

    @Operation(
            summary = "Get debtors",
            description = "Get debtors and their debts by debtor's id"
    )
    @GetMapping
    public ResponseEntity<List<DebtorDto>> getAllDebts(@RequestParam(required = true) int appUserId) {
        return ResponseEntity.ok(debtorService.getDebtsByAppUserId(appUserId));
    }

}
